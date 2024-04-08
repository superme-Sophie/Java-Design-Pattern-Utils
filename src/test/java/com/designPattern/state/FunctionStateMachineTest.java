package com.designPattern.state;

import org.junit.jupiter.api.Test;

public class FunctionStateMachineTest {

    @Test
    public void test(){
        ConsumerStateMachine consumerStateMachine = new ConsumerStateMachine(State.S1);
        consumerStateMachine.next(State.S2, new Param("QQQQ"));
        consumerStateMachine.next(State.S3, new Param("GGG"));
        consumerStateMachine.next(State.S3, new Param("TTT"));

        SupplierStateMachine supplierStateMachine = new SupplierStateMachine(State.S1);
        System.out.println(supplierStateMachine.next(State.S2));
        System.out.println(supplierStateMachine.next(State.S3));
        System.out.println(supplierStateMachine.next(State.S3));

        FunctionStateMachine functionStateMachine = new FunctionStateMachine(State.S1);
        System.out.println(functionStateMachine.next(State.S2,new Param("ZZZ")));
        System.out.println(functionStateMachine.next(State.S3,new Param("ZZZ")));
        System.out.println(functionStateMachine.next(State.S3,new Param("ZZZ")));

        Param a = new Param("A");
        PredicateStateMachine predicateStateMachine = new PredicateStateMachine(State.S1);
        System.out.println(predicateStateMachine.next(State.S2, a));
        a = new Param("B");
        System.out.println(predicateStateMachine.next(State.S3, a));
        System.out.println(predicateStateMachine.next(State.S3, a));
    }
}
