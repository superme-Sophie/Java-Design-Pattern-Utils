package com.designPattern.state;

public class PredicateStateMachine extends AbstractPredicateStateMachine<State, Param> {

    public PredicateStateMachine(State state) {
        super(state);
        insert(
                State.S1, State.S2, param -> param.getName().equals("A")
        ).insert(
                State.S2, State.S3, param -> param.getName().equals("B")
        ).insert(
                State.S3, State.S3, param -> param.getName().equals("C")
        );
    }
}
