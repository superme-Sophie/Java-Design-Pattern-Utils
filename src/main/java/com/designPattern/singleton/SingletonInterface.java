package com.designPattern.singleton;

/**
 * 使用单例模式管理器的资源类需要实现这个接口
 */
public interface SingletonInterface {

    /**
     * 当前实例是否失效
     */
    boolean isLoseEffectiveness();

    /**
     * 使当前实例失效
     */
    void loseEffectiveness();
}
