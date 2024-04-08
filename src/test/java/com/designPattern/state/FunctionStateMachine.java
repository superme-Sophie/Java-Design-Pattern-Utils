package com.designPattern.state;

public class FunctionStateMachine extends AbstractParamFunctionStateMachine<State, Param>{

    public FunctionStateMachine(State state) {
        super(state);
        insert(State.S1,State.S2, param -> {
            System.out.println("s1->s2" + param);
        }).
        insert(State.S2,State.S3, param -> {
            System.out.println("s2->s3" + param);
        }).
        insert(State.S3,State.S3, param -> {
            System.out.println("s3->s3" + param);
        });
    }
}
