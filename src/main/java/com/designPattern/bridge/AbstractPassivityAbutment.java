package com.designPattern.bridge;

/**
 * 桥接模式
 * 被动方
 *
 * @param <CalledInput>  被动者的入参
 * @param <CalledOutput> 被动者的出参
 */
public abstract class AbstractPassivityAbutment<CalledInput, CalledOutput> {

    public abstract CalledOutput JointPoint(CalledInput input);
}
