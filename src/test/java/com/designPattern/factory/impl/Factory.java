package com.designPattern.factory.impl;

import com.designPattern.factory.AbstractFactory;

public class Factory extends AbstractFactory<FacotryEnums, Instance> {

    public Factory() {
        super(FacotryEnums.class);
    }

    @Override
    public Instance createInstance(FacotryEnums facotryEnums) {
        switch (facotryEnums) {
            case F1: {
                return new Instance1();
            }
            case F2: {
                return new Instance2();
            }
            default: {
                return new Instance3();
            }
        }
    }
}
