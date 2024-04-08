package com.designPattern.observer.eventbus;

import java.util.concurrent.Executor;

/**
 * 异步(线程池)事件总线
 * register注册实现了@Subscribe的方法 仅支持一个入参
 * post会将事件发送给每一个参数类型匹配的事件处理器
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
