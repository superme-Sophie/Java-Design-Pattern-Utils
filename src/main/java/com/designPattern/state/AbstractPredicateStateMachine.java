package com.designPattern.state;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public abstract class AbstractPredicateStateMachine<State extends Enum<State>, Param> {

    protected final Map<State, Map<State, Predicate<Param>>> graph = new ConcurrentHashMap<>();
    protected State current;

    public AbstractPredicateStateMachine(State current) {
        this.current = current;
    }

    public AbstractPredicateStateMachine<State, Param> insert(State begin, State end, Predicate<Param> function) {
        graph.putIfAbsent(begin, new HashMap<>());
        Map<State, Predicate<Param>> nextGraph = graph.get(begin);
        nextGraph.putIfAbsent(end, function);
        return this;
    }

    public boolean next(State state, Param param) {
        if (graph.containsKey(current)) {
            Map<State, Predicate<Param>> nextGraph = graph.get(current);
            if (nextGraph.containsKey(state)) {
                current = state;
                return nextGraph.get(state).test(param);
            } else {
                throw new IllegalArgumentException("illegal state " + state + " is not " + current.name() + " next state");
            }
        } else {
            throw new IllegalArgumentException("current state " + current + " has not next state");
        }
    }
}
