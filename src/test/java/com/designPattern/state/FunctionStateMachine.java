package com.designPattern.state;

public class FunctionStateMachine extends AbstractFunctionStateMachine<State, Param, Param> {

    public FunctionStateMachine(State state) {
        super(state);
        insert(State.S1, State.S2, (p) -> {
            System.out.println("s1->s2");
            return new Param("123" + p.getName());
        }).insert(State.S2, State.S3, (p) -> {
            System.out.println("s2->s3");
            return new Param("123" + p.getName());
        }).insert(State.S3, State.S3, (p) -> {
            System.out.println("s3->s3");
            return new Param("123" + p.getName());
        });
    }
}
