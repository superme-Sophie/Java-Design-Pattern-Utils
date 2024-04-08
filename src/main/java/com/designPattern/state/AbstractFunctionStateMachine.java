package com.designPattern.state;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public abstract class AbstractFunctionStateMachine<State extends Enum<State>, Input, Output> {

    protected final Map<State, Map<State, Function<Input, Output>>> graph = new ConcurrentHashMap<>();
    protected State current;

    public AbstractFunctionStateMachine(State current) {
        this.current = current;
    }

    public AbstractFunctionStateMachine<State, Input, Output> insert(State begin, State end, Function<Input, Output> function) {
        graph.putIfAbsent(begin, new HashMap<>());
        Map<State, Function<Input, Output>> nextGraph = graph.get(begin);
        nextGraph.putIfAbsent(end, function);
        return this;
    }

    public Output next(State state, Input Input) {
        if (graph.containsKey(current)) {
            Map<State, Function<Input, Output>> nextGraph = graph.get(current);
            if (nextGraph.containsKey(state)) {
                current = state;
                return nextGraph.get(state).apply(Input);
            } else {
                throw new IllegalArgumentException("illegal state " + state + " is not " + current.name() + " next state");
            }
        } else {
            throw new IllegalArgumentException("current state " + current + " has not next state");
        }
    }
}
