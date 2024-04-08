package com.designPattern.state;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.function.Supplier;

public abstract class AbstractSupplierStateMachine<State extends Enum<State>, Output> {

    protected final Map<State, Map<State, Supplier<Output>>> graph = new ConcurrentHashMap<>();
    protected State current;

    public AbstractSupplierStateMachine(State current) {
        this.current = current;
    }

    public AbstractSupplierStateMachine<State, Output> insert(State begin, State end, Supplier<Output> function) {
        graph.putIfAbsent(begin, new HashMap<>());
        Map<State, Supplier<Output>> nextGraph = graph.get(begin);
        nextGraph.putIfAbsent(end, function);
        return this;
    }

    public Output next(State state) {
        if (graph.containsKey(current)) {
            Map<State, Supplier<Output>> nextGraph = graph.get(current);
            if (nextGraph.containsKey(state)) {
                current = state;
                return nextGraph.get(state).get();
            } else {
                throw new IllegalArgumentException("illegal state " + state + " is not " + current.name() + " next state");
            }
        } else {
            throw new IllegalArgumentException("current state " + current + " has not next state");
        }
    }
}
