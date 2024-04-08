package com.designPattern.flyweight;

public class FlyWeightManager extends AbstractFlyWeightManager<FlyWeightEnums, FlyWeightEntity>{

    public FlyWeightManager() {
        insert(FlyWeightEnums.F1, new FlyWeightEntity("F1","G1"));
        insert(FlyWeightEnums.F2, new FlyWeightEntity("F1","G1"));
        insert(FlyWeightEnums.F3, new FlyWeightEntity("F1","G1"));
    }
}
