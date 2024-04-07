package com.designPattern.chainResponsibility;

import com.designPattern.chainResponsibility.enums.ExecutionMode;
import com.designPattern.chainResponsibility.enums.ModeManger;
import com.designPattern.chainResponsibility.enums.SequenceMode;
import com.designPattern.chainResponsibility.enums.WeightedMode;
import com.designPattern.chainResponsibility.node.ChainResponsibilityWeightNode;

import java.util.Optional;

/**
 * 权重责任链
 */
public class WeightedChainResponsibility<P> extends AbstractChainResponsibility<ChainResponsibilityWeightNode<P>, P> {

    protected WeightedMode weightedMode;
    protected ExecutionMode executionMode;


    public void weightedMode(WeightedMode weightedMode) {
        this.weightedMode = weightedMode;
    }

    public void executionMode(ExecutionMode executionMode) {
        this.executionMode = executionMode;
    }

    public WeightedChainResponsibility() {
        this(ExecutionMode.OnceOnly);
    }

    public WeightedChainResponsibility(ExecutionMode executionMode) {
        this(executionMode, SequenceMode.Sequential);
    }

    public WeightedChainResponsibility(ExecutionMode executionMode, SequenceMode order) {
        this(WeightedMode.HeavierFirst, executionMode, order);
    }

    public WeightedChainResponsibility(WeightedMode weightedMode, ExecutionMode executionMode, SequenceMode order) {
        this.weightedMode = weightedMode;
        this.executionMode = executionMode;
    }


    @Override
    protected WeightedChainResponsibility<P> insert(ChainResponsibilityWeightNode<P> node) {
        if (node == null) {
            throw new IllegalArgumentException("不允许插入空节点");
        }
        if (head == null) {
            head = node;
            tail = node;
        }else if (node.compareTo(head) > 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            ChainResponsibilityWeightNode<P> current = head;
            while(current.next != null && node.compareTo((ChainResponsibilityWeightNode<P>) current.next) <= 0){
                current = (ChainResponsibilityWeightNode<P>) current.next;
            }
            node.next = current.next;
            if (current.next != null) {
                current.next.prev = node;
            }
            current.next = node;
            node.prev = current;
            if (current == tail) {
                tail = node;
            }
        }
        return this;
    }

    @Override
    protected P handle(P entity) {
        System.out.println("执行模式: " + executionMode.getName());
        System.out.println("执行顺序: " + weightedMode.getName());
        switch (weightedMode) {
            case HeavierFirst: {
                Optional.ofNullable(head).ifPresent(h -> {
                    h.handle(entity, ModeManger.builder()
                            .weightedMode(weightedMode).executionMode(executionMode).build());
                });
                break;
            }
            case LighterFirst: {
                Optional.ofNullable(tail).ifPresent(t -> {
                    t.handle(entity, ModeManger.builder()
                            .weightedMode(weightedMode).executionMode(executionMode).build());
                });
                break;
            }
        }
        return entity;
    }
}
