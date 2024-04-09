package com.designPattern.bridge;

import java.util.Map;

/**
 * 桥接模式管理器
 * 注册主动者
 * 注册被动者
 * 传入指定类型后可以自由组合
 */
public abstract class AbstractBridgeManager<Input, Output, CallInput, CallOutput, PassivityEnums extends Enum<PassivityEnums>, InitiativeEnums extends Enum<InitiativeEnums>> {

    public CallOutput bridge(PassivityEnums passivityEnums, InitiativeEnums initiativeEnums, Input input) {
        AbstractPassivityAbutment<CallInput, Output> passivityAbutment = passivityAbutmentInstance().get(passivityEnums);
        AbstractInitiativeAbutment<Input, Output, CallInput, CallOutput> initiativeAbutment = initiativeAbutmentInstance().get(initiativeEnums);
        return initiativeAbutment.bridge(passivityAbutment).call(input);
    }

    protected abstract Map<PassivityEnums, AbstractPassivityAbutment<CallInput, Output>> passivityAbutmentInstance();

    protected abstract Map<InitiativeEnums, AbstractInitiativeAbutment<Input, Output, CallInput, CallOutput>> initiativeAbutmentInstance();
}
