package com.designPattern.state;

public class SupplierStateMachine extends AbstractSupplierStateMachine<State, Param> {

    public SupplierStateMachine(State state) {
        super(state);
        insert(State.S1, State.S2, () -> {
            System.out.println("s1->s2");
            return new Param("123");
        }).insert(State.S2, State.S3, () -> {
            System.out.println("s2->s3");
            return new Param("123");
        }).insert(State.S3, State.S3, () -> {
            System.out.println("s3->s3");
            return new Param("123");
        });
    }
}
