package com.designPattern.singleton;

public abstract class AbstractSingletonManager<SingletonBean extends SingletonInterface> {

    private volatile SingletonBean singletonBean;
    private final Object lock = new Object();

    public AbstractSingletonManager(SingletonEnums enums) {
        if (enums == SingletonEnums.PRE_LOAD) {
            this.singletonBean = createBean();
        }
    }

    public SingletonBean getBean(){
        if (singletonBean == null || singletonBean.isLoseEffectiveness()) {
             synchronized (lock) {
                 if (singletonBean == null || singletonBean.isLoseEffectiveness()) {
                     this.singletonBean = createBean();
                 }
             }
        }
        return this.singletonBean;
    }

    public abstract SingletonBean createBean();
}
