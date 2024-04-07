package com.designPattern.singleton.impl;

import com.designPattern.singleton.AbstractMultitonManager;
import com.designPattern.singleton.SingletonEnums;

public class MultitonManager extends AbstractMultitonManager<MultitionEnums,SingletonBean> {


    public MultitonManager(SingletonEnums type, Class<MultitionEnums> enums) {
        super(type, enums);
    }

    @Override
    public SingletonBean createBean(MultitionEnums multitionEnums) {
        switch (multitionEnums) {
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
