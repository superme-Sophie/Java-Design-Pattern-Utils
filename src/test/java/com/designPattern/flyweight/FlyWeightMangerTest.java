package com.designPattern.flyweight;

import org.junit.jupiter.api.Test;

public class FlyWeightMangerTest {

    private static final FlyWeightManager MANAGER = new FlyWeightManager();

    @Test
    public void test(){
        System.out.println(MANAGER.get(FlyWeightEnums.F1));
        System.out.println(MANAGER.get(FlyWeightEnums.F2));
        System.out.println(MANAGER.get(FlyWeightEnums.F3));
        System.out.println(MANAGER.get(FlyWeightEnums.F3) == MANAGER.get(FlyWeightEnums.F3));
        System.out.println(MANAGER.get(FlyWeightEnums.F1) == MANAGER.get(FlyWeightEnums.F1));
        System.out.println(MANAGER.get(FlyWeightEnums.F2) == MANAGER.get(FlyWeightEnums.F2));
        System.out.println(MANAGER.get(FlyWeightEnums.F1) == MANAGER.get(FlyWeightEnums.F3));
    }
}
