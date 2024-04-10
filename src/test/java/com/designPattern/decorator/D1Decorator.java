package com.designPattern.decorator;

import com.designPattern.common.InputParam;
import com.designPattern.common.OutputParam;

public class D1Decorator extends AbstractDecorator<InputParam, OutputParam> {
    public D1Decorator(DecoratorInterface<InputParam, OutputParam> decorated) {
        super(decorated);
    }

    @Override
    protected void beforeOperation(InputParam inputParam) {
        System.out.println("D1 修饰 前置执行");
    }

    @Override
    protected void afterOperation(InputParam inputParam, OutputParam outputParam) {
        System.out.println("D1 修饰 后置执行");
    }

}
