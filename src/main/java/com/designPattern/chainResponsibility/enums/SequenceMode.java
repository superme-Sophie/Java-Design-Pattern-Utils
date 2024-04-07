package com.designPattern.chainResponsibility.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SequenceMode {

    Sequential("正序"),
    Reverse("反序");

    private final String name;
}
