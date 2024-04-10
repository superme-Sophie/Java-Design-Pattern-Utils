package com.designPattern.bridge;

/**
 * 桥接模式主动方
 * 需要在call方法中合适的时候主动调用被动方提供的
 * another.JointPoint方法
 *
 * @param <CallerInput>  主动者的入参
 * @param <CallerOutput> 主动者的出参
 * @param <CalledInput>  被动者的入参
 * @param <CalledOutput> 被动者的出参
 */
public abstract class AbstractInitiativeAbutment<CallerInput, CallerOutput, CalledInput, CalledOutput> {

    public AbstractInitiativeAbutment() {

    }

    protected AbstractPassivityAbutment<CalledInput, CalledOutput> another;


    public AbstractInitiativeAbutment<CallerInput, CallerOutput, CalledInput, CalledOutput> bridge(AbstractPassivityAbutment<CalledInput, CalledOutput> another) {
        this.another = another;
        return this;
    }

    public abstract CallerOutput call(CallerInput input);
}
