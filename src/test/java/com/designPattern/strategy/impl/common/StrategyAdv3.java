package com.designPattern.strategy.impl.common;

import com.designPattern.common.InputParam;
import com.designPattern.common.OutputParam;

public class StrategyAdv3 implements StrategyAdv<InputParam, OutputParam> {
    @Override
    public OutputParam execute(InputParam inputParam) {
        return new OutputParam(inputParam.getInput() + " adv3");
    }

    @Override
    public void init() {
        System.out.println("初始化");
    }

    @Override
    public void adv() {

    }
}
