package com.designPattern.observer;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DefaultMessage implements Message {

    private final String data;
}
