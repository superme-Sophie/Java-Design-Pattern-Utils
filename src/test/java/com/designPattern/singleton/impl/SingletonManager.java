package com.designPattern.singleton.impl;

import com.designPattern.singleton.AbstractSingletonManager;
import com.designPattern.singleton.SingletonEnums;

public class SingletonManager extends AbstractSingletonManager<SingletonBean> {

    public SingletonManager(SingletonEnums enums) {
        super(enums);
    }

    @Override
    public SingletonBean createBean() {
        return new SingletonBean("GGG");
    }
}
