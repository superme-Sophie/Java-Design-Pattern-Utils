package com.designPattern.decorator;


/**
 * 修饰器抽象类
 *
 * @param <DecoratorInput>  装饰者入参
 * @param <DecoratorOutput> 装饰者出参
 */
public abstract class AbstractDecorator<DecoratorInput, DecoratorOutput> implements DecoratorInterface<DecoratorInput, DecoratorOutput> {

    protected DecoratorInterface<DecoratorInput, DecoratorOutput> decorated;

    public AbstractDecorator(DecoratorInterface<DecoratorInput, DecoratorOutput> decorated) {
        this.decorated = decorated;
    }

    @Override
    public DecoratorOutput embellishMethod(DecoratorInput decoratorInput) {
        beforeOperation(decoratorInput);
        DecoratorOutput decoratorOutput = decorated.embellishMethod(decoratorInput);
        afterOperation(decoratorInput, decoratorOutput);
        return decoratorOutput;
    }

    /**
     * 调用被装饰类前置操作
     */
    protected abstract void beforeOperation(DecoratorInput input);

    /**
     * 被装饰类结束后置操作
     */
    protected abstract void afterOperation(DecoratorInput input, DecoratorOutput output);

}
