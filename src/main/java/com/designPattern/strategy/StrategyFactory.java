package com.designPattern.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory<StrategyEnums extends Enum<StrategyEnums>, StrategyInterface extends Strategy<Input, Output>, Input, Output> {

    public final Map<StrategyEnums, StrategyInterface> strategyMap = new HashMap<>();

    public static <StrategyEnums extends Enum<StrategyEnums>, StrategyInterface extends Strategy<Input, Output>, Input, Output> StrategyFactory<StrategyEnums, StrategyInterface, Input, Output> begin() {
        return new StrategyFactory<>();
    }

    public StrategyFactory<StrategyEnums, StrategyInterface, Input, Output> add(StrategyEnums enums, StrategyInterface strategy) {
        strategy.init();
        strategyMap.put(enums, strategy);
        return this;
    }

    public StrategyDistributor<StrategyEnums, StrategyInterface, Input, Output> finish() {
        return new StrategyDistributor<>(strategyMap);
    }

}
