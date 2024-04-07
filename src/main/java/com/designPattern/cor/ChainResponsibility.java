package com.designPattern.cor;

import com.designPattern.cor.enums.ExecutionMode;
import com.designPattern.cor.enums.ModeManger;
import com.designPattern.cor.enums.SequenceMode;
import com.designPattern.cor.node.ChainResponsibilityNode;

import java.util.Optional;

/**
 * 无权重责任链
 */
public class ChainResponsibility<P> extends AbstractChainResponsibility<ChainResponsibilityNode<P>, P>{

    protected ChainResponsibilityNode<P> head;
    protected ChainResponsibilityNode<P> tail;

    protected ExecutionMode executionMode;
    protected SequenceMode sequenceMode;

    public void handleMode(ExecutionMode handleMode) {
        this.executionMode = handleMode;
    }

    public void order(SequenceMode order) {
        this.sequenceMode = order;
    }

    public ChainResponsibility() {
        this(ExecutionMode.OnceOnly, SequenceMode.Sequential);
    }

    public ChainResponsibility(ExecutionMode executionMode) {
        this(executionMode, SequenceMode.Sequential);
    }

    public ChainResponsibility(SequenceMode sequenceMode) {
        this(ExecutionMode.OnceOnly, sequenceMode);
    }

    public ChainResponsibility(ExecutionMode executionMode, SequenceMode sequenceMode) {
        this.executionMode = executionMode;
        this.sequenceMode = sequenceMode;
    }

    @Override
    public ChainResponsibility<P> insert(ChainResponsibilityNode<P> node) {
        node.init();
        node.next(null);
        node.prev(null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next(node);
            node.prev(tail);
            tail = node;
        }
        return this;
    }

    public P handle(P entity) {
        System.out.println("执行模式: " + executionMode.getName());
        System.out.println("排序模式: " + sequenceMode.getName());
        switch (sequenceMode) {
            case Sequential: {
                Optional.ofNullable(head).ifPresent(h -> {
                    h.handle(entity, ModeManger.builder()
                            .sequenceMode(sequenceMode).executionMode(executionMode).build());
                });
                break;
            }
            case Reverse: {
                Optional.ofNullable(tail).ifPresent(t -> {
                    t.handle(entity, ModeManger.builder()
                            .sequenceMode(sequenceMode).executionMode(executionMode).build());
                });
                break;
            }
        }
        return entity;
    }

}
