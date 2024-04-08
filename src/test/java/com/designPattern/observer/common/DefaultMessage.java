package com.designPattern.observer.common;

import com.designPattern.observer.common.Message;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DefaultMessage implements Message {

    private final String data;
}
