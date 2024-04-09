package com.designPattern.bridge;

/**
 * 桥接模式
 * 被动方
 */
public abstract class AbstractPassivityAbutment<Input, Output> {

    public abstract Output JointPoint(Input input);
}
