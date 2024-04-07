package com.designPattern.singleton.impl;

import com.designPattern.singleton.SingletonInterface;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SingletonBean implements SingletonInterface {

    private final String name;

    public void print(){
        System.out.println(name);
    }

    @Override
    public boolean isLoseEffectiveness() {
        return name.equals("effect");
    }

    @Override
    public void loseEffectiveness() {
        System.out.println("销毁xxx");
    }
}
