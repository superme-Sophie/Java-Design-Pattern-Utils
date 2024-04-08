package com.designPattern.state;

import java.util.Arrays;
import java.util.Objects;

public class StateMachine extends AbstractParamStateMachine<State, Param> {

    public StateMachine() {
        super(Arrays.asList(
                new State[]{State.S1, State.S2},
                new State[]{State.S2, State.S3},
                new State[]{State.S2, State.S1},
                new State[]{State.S3, State.S1}
        ), State.S1);
    }

    @Override
    public void change(State prev, State next, Param param) {
        switch (prev) {
            case S1: {
                if (next == State.S2) {
                    System.out.println("s1->s2" + param);
                }
                break;
            }
            case S2: {
                switch (next) {
                    case S1: {
                        System.out.println("s2->s1" + param);
                        break;
                    }
                    case S3: {
                        System.out.println("s2->s3" + param);
                    }
                }
                break;
            }
            case S3: {
                if (next == State.S1) {
                    System.out.println("s3->s1" + param);
                }
                break;
            }
        }
    }


}
