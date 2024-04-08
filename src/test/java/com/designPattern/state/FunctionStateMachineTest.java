package com.designPattern.state;

import org.junit.jupiter.api.Test;

public class FunctionStateMachineTest {

    @Test
    public void test(){
        FunctionStateMachine machine = new FunctionStateMachine(State.S1);
        machine.next(State.S2, new Param("QQQQ"));
        machine.next(State.S3, new Param("GGG"));
        machine.next(State.S3, new Param("TTT"));
    }
}
