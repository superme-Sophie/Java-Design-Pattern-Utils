package com.designPattern.decorator;

import com.designPattern.common.InputParam;
import com.designPattern.common.OutputParam;

public class Base2Decorator extends AbstractBaseDecorator<InputParam, OutputParam> {

    @Override
    protected OutputParam operation(InputParam inputParam) {
        System.out.println("BASE2 被修饰者 执行");
        return new OutputParam(inputParam.getInput() + "base2");
    }
}
