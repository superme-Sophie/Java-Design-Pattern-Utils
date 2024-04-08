package com.designPattern.state;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public abstract class AbstractParamFunctionStateMachine<State extends Enum<State>, Param> {

    protected final Map<State, Map<State, Consumer<Param>>> graph = new ConcurrentHashMap<>();
    protected State current;

    public AbstractParamFunctionStateMachine(State current) {
        this.current = current;
    }

    public AbstractParamFunctionStateMachine<State,Param> insert(State begin, State end, Consumer<Param> function) {
        graph.putIfAbsent(begin, new HashMap<>());
        Map<State, Consumer<Param>> nextGraph = graph.get(begin);
        nextGraph.putIfAbsent(end, function);
        return this;
    }

    public void next(State state, Param param) {
        if (graph.containsKey(current)) {
            Map<State, Consumer<Param>> nextGraph = graph.get(current);
            if (nextGraph.containsKey(state)) {
                nextGraph.get(state).accept(param);
                current = state;
            } else {
                throw new IllegalArgumentException("illegal state " + state + " is not " + current.name() + " next state");
            }
        }
    }
}
