package com.designPattern.singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SingletonEnums {

    LAZY("懒加载"),
    PRE_LOAD("预加载");

    private final String name;
}
