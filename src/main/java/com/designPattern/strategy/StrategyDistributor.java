package com.designPattern.strategy;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class StrategyDistributor<StrategyEnums extends Enum<StrategyEnums>, StrategyInterface extends Strategy<Input,Output>, Input, Output> {

    public final Map<StrategyEnums, StrategyInterface> strategyMap;

    public Output distribute(StrategyEnums enums, Input input) {
        return strategyMap.get(enums).execute(input);
    }

    public StrategyInterface getInstance(StrategyEnums enums) {
        return strategyMap.get(enums);
    }
}
