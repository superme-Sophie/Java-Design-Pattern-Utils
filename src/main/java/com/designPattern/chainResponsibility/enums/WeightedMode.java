package com.designPattern.chainResponsibility.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeightedMode {

    LighterFirst("从轻到重"),
    HeavierFirst("从重到轻");

    private final String name;
}
