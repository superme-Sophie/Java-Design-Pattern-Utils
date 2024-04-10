package com.designPattern.decorator;

import com.designPattern.common.InputParam;
import org.junit.jupiter.api.Test;

public class DecoratorTest {

    @Test
    public void test() {
        System.out.println(new D1Decorator(new Base1Decorator()).embellishMethod(new InputParam("XXX")));
        System.out.println("\n");
        System.out.println(new D2Decorator(new Base2Decorator()).embellishMethod(new InputParam("YYY")));
        System.out.println("\n");
        System.out.println(new D2Decorator(new Base1Decorator()).embellishMethod(new InputParam("ZZZ")));
        System.out.println("\n");
        System.out.println(new D1Decorator(new Base2Decorator()).embellishMethod(new InputParam("CCC")));
    }
}
