package com.designPattern.bridge;

import java.util.Map;

/**
 * 桥接模式管理器
 * 注册主动者
 * 注册被动者
 * 传入指定类型后可以自由组合
 *
 * @param <CallerInput>  主动者的入参
 * @param <CallerOutput> 主动者的出参
 * @param <CalledInput>  被动者的入参
 * @param <CalledOutput> 被动者的出参
 * @param <InitiativeEnums> 主动调用者的类型枚举
 * @param <PassivityEnums>> 被调用者的类型枚举
 *
 */
public abstract class AbstractBridgeManager<CallerInput, CallerOutput, CalledInput, CalledOutput, InitiativeEnums extends Enum<InitiativeEnums>, PassivityEnums extends Enum<PassivityEnums>> {

    /**
     * 桥接模式调用方法 传递指定枚举和入参
     * 自动桥接实现类并返回结果
     */
    public CallerOutput bridge(PassivityEnums passivityEnums, InitiativeEnums initiativeEnums, CallerInput callerInput) {
        AbstractPassivityAbutment<CalledInput, CalledOutput> passivityAbutment = passivityAbutmentInstance().get(passivityEnums);
        AbstractInitiativeAbutment<CallerInput, CallerOutput, CalledInput, CalledOutput> initiativeAbutment = initiativeAbutmentInstance().get(initiativeEnums);
        return initiativeAbutment.bridge(passivityAbutment).call(callerInput);
    }

    protected abstract Map<PassivityEnums, AbstractPassivityAbutment<CalledInput, CalledOutput>> passivityAbutmentInstance();

    protected abstract Map<InitiativeEnums, AbstractInitiativeAbutment<CallerInput, CallerOutput, CalledInput, CalledOutput>> initiativeAbutmentInstance();
}
