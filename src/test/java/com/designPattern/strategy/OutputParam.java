package com.designPattern.strategy;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class OutputParam {

    private final String output;

    public void log(){
        System.out.println("========\n" + this.output + "\n=========\n");
    }
}
