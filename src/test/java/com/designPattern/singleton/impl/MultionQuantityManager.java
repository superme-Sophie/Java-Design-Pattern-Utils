package com.designPattern.singleton.impl;

import com.designPattern.singleton.AbstractMultionQuantityManager;
import com.designPattern.singleton.SingletonEnums;

public class MultionQuantityManager extends AbstractMultionQuantityManager<MultitionEnums, SingletonBean> {

    public MultionQuantityManager(Integer quantity, SingletonEnums type, Class<MultitionEnums> enums) {
        super(quantity, type, enums);
    }

    @Override
    public SingletonBean createBean(MultitionEnums enums) {
        switch (enums) {
            case M1: {
                return new SingletonBean("M1");
            }
            case M2: {
                return new SingletonBean("M2");
            }
            case M3: {
                return new SingletonBean("M3");
            }
            default: {
                return new SingletonBean("M4");
            }
        }
    }
}
