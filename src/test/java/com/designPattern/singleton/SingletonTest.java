package com.designPattern.singleton;

import com.designPattern.singleton.impl.*;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void test(){

        // 懒加载 单类单实例
        SingletonManager manager = new SingletonManager(SingletonEnums.LAZY);
        manager.getBean().print();

        // 懒加载 多类单实例
        MultitonManager multitonManager = new MultitonManager(SingletonEnums.LAZY, MultitionEnums.class);
        multitonManager.getBean(MultitionEnums.M1).print();
        multitonManager.getBean(MultitionEnums.M3).print();

        // 预加载 多类单实例
        MultitonManager manager1 = new MultitonManager(SingletonEnums.PRE_LOAD, MultitionEnums.class);
        manager1.getBean(MultitionEnums.M2).print();
        manager1.getBean(MultitionEnums.M4).print();

        // 懒加载 单类多实例
        SingletonQuantityManager manager2 = new SingletonQuantityManager(5, SingletonEnums.LAZY);
        manager2.getBean().print();
        System.out.println(manager2.getInstanceCount());
        manager2.additionalQuantity(10);
        System.out.println(manager2.getInstanceCount());
        manager2.reduceQuantity(9);
        System.out.println(manager2.getInstanceCount());

        // 预加载 多类多实例
        MultionQuantityManager manager3 = new MultionQuantityManager(5, SingletonEnums.PRE_LOAD, MultitionEnums.class);
        manager3.getBean(MultitionEnums.M3).print();
        manager3.getBean(MultitionEnums.M1).print();
        System.out.println(manager3.getInstanceCount());
        manager3.additionalQuantity(10);
        System.out.println(manager3.getInstanceCount());
        manager3.reduceQuantity(9);
        System.out.println(manager3.getInstanceCount());
    }
}
