package com.designPattern.observer;

public class Ob1 implements Observer<DefaultMessage> {
    @Override
    public void notify(DefaultMessage defaultMessage) {
        System.out.println("ob1" + defaultMessage.getData());
    }
}
