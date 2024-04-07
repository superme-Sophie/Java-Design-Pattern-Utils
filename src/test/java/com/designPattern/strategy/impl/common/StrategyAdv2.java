package com.designPattern.strategy.impl.common;

import com.designPattern.strategy.InputParam;
import com.designPattern.strategy.OutputParam;

public class StrategyAdv2 implements StrategyAdv<InputParam, OutputParam> {
    @Override
    public OutputParam execute(InputParam inputParam) {
        return new OutputParam(inputParam.getInput() + " adv2");
    }

    @Override
    public void init() {
        System.out.println("初始化");
    }

    @Override
    public void adv() {

    }
}
