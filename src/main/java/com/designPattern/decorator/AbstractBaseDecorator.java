package com.designPattern.decorator;

/**
 * 修饰器抽象类
 *
 * @param <DecoratorInput>  装饰者入参
 * @param <DecoratorOutput> 装饰者出参
 */
public abstract class AbstractBaseDecorator<DecoratorInput, DecoratorOutput> implements DecoratorInterface<DecoratorInput, DecoratorOutput> {

    public AbstractBaseDecorator() {
    }

    @Override
    public DecoratorOutput embellishMethod(DecoratorInput decoratorInput) {
        return operation(decoratorInput);
    }

    /**
     * 基础装饰类前置操作
     */
    protected abstract DecoratorOutput operation(DecoratorInput input);

}
