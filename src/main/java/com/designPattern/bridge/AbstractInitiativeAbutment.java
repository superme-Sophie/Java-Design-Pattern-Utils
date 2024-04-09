package com.designPattern.bridge;

/**
 * 桥接模式主动方
 * 需要再call方法中合适的时候主动调用another.JointPoint
 */
public abstract class AbstractInitiativeAbutment<Input, Output, CallInput, CallOutput> {

    public AbstractInitiativeAbutment() {

    }

    protected AbstractPassivityAbutment<CallInput, Output> another;


    public AbstractInitiativeAbutment<Input, Output, CallInput, CallOutput> bridge(AbstractPassivityAbutment<CallInput, Output> another) {
        this.another = another;
        return this;
    }

    public abstract CallOutput call(Input input);
}
