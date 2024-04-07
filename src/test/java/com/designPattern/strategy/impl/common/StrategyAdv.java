package com.designPattern.strategy.impl.common;

import com.designPattern.strategy.Strategy;

public interface StrategyAdv<I,O> extends Strategy<I,O> {

    public void adv();
}
