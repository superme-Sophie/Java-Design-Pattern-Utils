package com.designPattern.state;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StateMachineTest {

    @Test
    public void test(){
        StateMachine machine = new StateMachine();
        machine.next(State.S2);
        machine.next(State.S1, new Param("QSC"));
        try {
            machine.next(State.S3);
        } catch (IllegalArgumentException e) {
            log.error("异常状态转移", e);
        }

    }
}
