package com.designPattern.chainResponsibility.node;

import com.designPattern.chainResponsibility.enums.ExecutionMode;
import com.designPattern.chainResponsibility.enums.ModeManger;
import com.designPattern.chainResponsibility.enums.SequenceMode;

import java.util.Optional;

public abstract class ChainResponsibilityNode<Params> extends AbstractChainResponsibilityNode<Params> {

    public void handle(Params entity, ModeManger manger) {
        boolean flag = false;
        if (canHandle(entity)) {
            flag = true;
            doHandle(entity);
        }
        if (manger.getExecutionMode() == ExecutionMode.OnceOnly && flag) {
            return;
        }
        switch (manger.getSequenceMode()) {
            case Sequential: {
                Optional.ofNullable(next).ifPresent(n -> {
                    n.handle(entity, manger);
                });
                break;
            }
            case Reverse: {
                Optional.ofNullable(prev).ifPresent(p -> {
                    p.handle(entity, manger);
                });
                break;
            }
        }
    }

}
