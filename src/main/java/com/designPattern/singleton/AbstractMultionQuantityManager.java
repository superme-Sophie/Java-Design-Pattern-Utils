package com.designPattern.singleton;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractMultionQuantityManager<E extends Enum<E>, SingletonBean extends SingletonInterface> {

    @Data
    private class MultionQuantityBean {
        private List<SingletonBean> list;
        private AtomicInteger iteration;

        public MultionQuantityBean(Integer iteration) {
            this.list = new CopyOnWriteArrayList<>();
            this.iteration = new AtomicInteger(iteration);
        }
    }

    private final Map<E, MultionQuantityBean> manager = new ConcurrentHashMap<>();

    public AbstractMultionQuantityManager(Integer quantity, SingletonEnums type, Class<E> enums) {
        quantity = quantity > 0 ? quantity : 1;
        if (type == SingletonEnums.PRE_LOAD) {
            for (E constant : enums.getEnumConstants()) {
                int less = quantity;
                MultionQuantityBean quantityBean = new MultionQuantityBean(less);
                manager.put(constant, quantityBean);
                List<SingletonBean> beans = quantityBean.getList();
                while (less > 0) {
                    beans.add(createBean(constant));
                    less--;
                }
            }
        }
    }

    public int getInstanceCount() {
        return manager.size();
    }

    public void additionalQuantity(int size) {
        for (Map.Entry<E, MultionQuantityBean> entry : manager.entrySet()) {
            MultionQuantityBean value = entry.getValue();
            List<SingletonBean> beans = value.getList();
            int less = size;
            while (less > 0) {
                beans.add(getBean(entry.getKey()));
                less--;
            }
        }
    }

    public void reduceQuantity(int size) {
        for (Map.Entry<E, MultionQuantityBean> entry : manager.entrySet()) {
            MultionQuantityBean value = entry.getValue();
            List<SingletonBean> beans = value.getList();
            int less = beans.size() - size > 0 ? size : beans.size() - 1;
            while (less > 0) {
                int curr = beans.size() - 1;
                beans.get(curr).loseEffectiveness();
                beans.remove(curr);
                less--;
            }
        }
    }

    public SingletonBean getBean(E enums) {
        MultionQuantityBean quantityBean = manager.get(enums);
        AtomicInteger iteration = quantityBean.getIteration();
        List<SingletonBean> beans = quantityBean.getList();
        if (beans.isEmpty()) {
            SingletonBean singletonBean = createBean(enums);
            beans.add(singletonBean);
            return singletonBean;
        }
        int cursor = iteration.getAndIncrement() % beans.size();
        SingletonBean bean = beans.get(cursor);
        if (bean != null && !bean.isLoseEffectiveness()) {
            return bean;
        }
        SingletonBean singletonBean = createBean(enums);
        beans.set(cursor, singletonBean);
        return singletonBean;
    }

    public abstract SingletonBean createBean(E enums);
}
