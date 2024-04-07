package com.designPattern.chainResponsibility.node;

import com.designPattern.chainResponsibility.enums.ExecutionMode;
import com.designPattern.chainResponsibility.enums.ModeManger;

import java.util.Optional;

public abstract class ChainResponsibilityWeightNode<Params> extends AbstractChainResponsibilityNode<Params> implements Comparable<ChainResponsibilityWeightNode<Params>> {

    public ChainResponsibilityWeightNode(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(ChainResponsibilityWeightNode<Params> other) {
        return Integer.compare(this.weight, other.weight);
    }

    public void handle(Params entity, ModeManger manger) {
        boolean flag = false;
        if (canHandle(entity)) {
            flag = true;
            doHandle(entity);
        }
        if (manger.getExecutionMode() == ExecutionMode.OnceOnly && flag) {
            return;
        }
        switch (manger.getWeightedMode()) {
            case HeavierFirst: {
                Optional.ofNullable(next).ifPresent(n -> {
                    n.handle(entity, manger);
                });
                break;
            }
            case LighterFirst: {
                Optional.ofNullable(prev).ifPresent(p -> {
                    p.handle(entity, manger);
                });
                break;
            }
        }
    }

    protected Integer weight;
}
