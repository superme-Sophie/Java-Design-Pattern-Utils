package com.designPattern.factory;

import com.designPattern.factory.impl.FacotryEnums;
import com.designPattern.factory.impl.Factory;
import com.designPattern.factory.impl.Instance;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    @Test
    public void test(){
        Factory factory = new Factory();
        System.out.println(factory.getInstance(FacotryEnums.F2).getClass().getName());
        System.out.println(factory.getInstance(FacotryEnums.F1).getClass().getName());
        System.out.println(factory.getInstance(FacotryEnums.F3).getClass().getName());
    }
}
