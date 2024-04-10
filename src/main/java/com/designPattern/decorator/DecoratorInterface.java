package com.designPattern.decorator;

public interface DecoratorInterface<Input, Output> {

    Output embellishMethod(Input input);
}
