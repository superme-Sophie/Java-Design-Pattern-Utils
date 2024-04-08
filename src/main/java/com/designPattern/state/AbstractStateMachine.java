package com.designPattern.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractStateMachine<State extends Enum<State>> {

    protected final Map<State, List<State>> graph = new ConcurrentHashMap<>();
    protected State current;

    public AbstractStateMachine(List<State[]> states, State begin) {
        current = begin;
        for (State[] state : states) {
            if (state.length != 2) {
                throw new IllegalArgumentException();
            }
            graph.putIfAbsent(state[0], new ArrayList<>());
            graph.get(state[0]).add(state[1]);
        }
    }

    public void next(State state) {
        if (graph.get(current).contains(state)) {
            change(current, state);
            current = state;
        } else {
            throw new IllegalArgumentException("illegal state " + state + " is not " + current.name() + " next state");
        }
    }

    protected abstract void change(State prev, State next);
}
