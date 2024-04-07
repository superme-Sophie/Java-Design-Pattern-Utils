package com.designPattern.cor.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExecutionMode {

    OnceOnly("仅处理一次"),
    CompleteFlow("全流程处理");

    private final String name;
}
