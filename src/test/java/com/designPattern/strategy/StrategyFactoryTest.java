package com.designPattern.strategy;

import com.designPattern.strategy.impl.common.*;
import org.junit.jupiter.api.Test;

public class StrategyFactoryTest {

    @Test
    public void test(){
        StrategyDistributor<StrategyEnums, StrategyAdv<InputParam,OutputParam>, InputParam, OutputParam> strategy =
                StrategyFactory.<StrategyEnums, StrategyAdv<InputParam,OutputParam>,InputParam, OutputParam>begin()
                .add(StrategyEnums.S1, new StrategyAdv1())
                .add(StrategyEnums.S2, new StrategyAdv2())
                .add(StrategyEnums.S3, new StrategyAdv3())
                .finish();

        strategy.distribute(StrategyEnums.S1, new InputParam("|")).log();
        strategy.distribute(StrategyEnums.S2, new InputParam("~")).log();
        strategy.distribute(StrategyEnums.S3, new InputParam("*")).log();

        strategy.getInstance(StrategyEnums.S1).adv();
    }
}
