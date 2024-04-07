package com.designPattern.singleton.impl;

import com.designPattern.singleton.AbstractSingletonQuantityManager;
import com.designPattern.singleton.SingletonEnums;

public class SingletonQuantityManager extends AbstractSingletonQuantityManager<SingletonBean> {
    public SingletonQuantityManager(Integer quantity, SingletonEnums enums) {
        super(quantity, enums);
    }

    @Override
    public SingletonBean createBean() {
        return new SingletonBean("CSS1");
    }

}
