package com.designPattern.chainResponsibility.node;

import com.designPattern.chainResponsibility.enums.ModeManger;

public abstract class AbstractChainResponsibilityNode<Params> {

    public AbstractChainResponsibilityNode<Params> next = null;
    public AbstractChainResponsibilityNode<Params> prev = null;

    public void next(AbstractChainResponsibilityNode<Params> next) {
        this.next = next;
    }

    public void prev(AbstractChainResponsibilityNode<Params> prev) {
        this.prev = prev;
    }

    public abstract void handle(Params entity, ModeManger modeManger);

    /**
     * 初始化 加入链路中时会自动调用
     */
    public abstract void init();

    /**
     * 责任链模式 用于判断是否需要走子类的过滤逻辑
     *
     * @param entity 规则实体
     * @return 当前expr表达式是否符合该节点
     */
    public abstract boolean canHandle(Params entity);

    /**
     * 责任链模式 用于执行子类的过滤操作
     *
     * @param entity 传递参数
     */
    public abstract void doHandle(Params entity);
}
