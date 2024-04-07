package com.designPattern.singleton;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractSingletonQuantityManager<SingletonBean extends SingletonInterface> {

    private final List<SingletonBean> manager = new CopyOnWriteArrayList<>();
    private final AtomicInteger iteration;
    public AbstractSingletonQuantityManager(Integer quantity, SingletonEnums enums) {
        if (enums == SingletonEnums.PRE_LOAD) {
            while (quantity > 0) {
                manager.add(createBean());
                quantity--;
            }
        }
        iteration = new AtomicInteger(0);
    }

    public int getInstanceCount() {
        return manager.size();
    }

    public void additionalQuantity(int size) {
        int less = size;
        while (less > 0) {
            manager.add(getBean());
            less--;
        }
    }

    public void reduceQuantity(int size) {
        int less = manager.size() - size > 0 ? size : manager.size() - 1;
        while (less > 0) {
            int curr = manager.size() - 1;
            manager.get(curr).loseEffectiveness();
            manager.remove(curr);
            less--;
        }
    }

    public SingletonBean getBean() {
        if (manager.isEmpty()) {
            SingletonBean singletonBean = createBean();
            manager.add(singletonBean);
            return singletonBean;
        }
        int cursor = iteration.getAndIncrement() % manager.size();
        SingletonBean bean = manager.get(cursor);
        if (bean != null && !bean.isLoseEffectiveness()) {
            return bean;
        }
        SingletonBean singletonBean = createBean();
        manager.set(cursor, singletonBean);
        return singletonBean;
    }

    public abstract SingletonBean createBean();
}
