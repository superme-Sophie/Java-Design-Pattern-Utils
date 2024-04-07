package com.designPattern.strategy;

public interface Strategy<Input,Output> {

    Output execute(Input input);

    public void init();
}
