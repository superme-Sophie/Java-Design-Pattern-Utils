package com.designPattern.state;

import java.util.List;

public abstract class AbstractParamStateMachine<State extends Enum<State>, Param> extends AbstractStateMachine<State> {

    public AbstractParamStateMachine(List<State[]> states, State begin) {
        super(states, begin);
    }

    public void next(State state, Param param) {
        if (graph.containsKey(current)) {
            if (graph.get(current).contains(state)) {
                change(current, state, param);
                current = state;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    protected void change(State prev, State next) {
        change(prev,next,null);
    }

    protected abstract void change(State prev, State next, Param param);
}
