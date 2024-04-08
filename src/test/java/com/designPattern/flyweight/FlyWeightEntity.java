package com.designPattern.flyweight;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class FlyWeightEntity implements FlyWeight {

    private final String x;
    private final String y;
}
