package com.designPattern.state;

@FunctionalInterface
public interface MachineFunction {

    public void iteration(Object... args);
}
