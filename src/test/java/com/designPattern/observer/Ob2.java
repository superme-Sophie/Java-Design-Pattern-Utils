package com.designPattern.observer;

public class Ob2 implements Observer<DefaultMessage> {
    @Override
    public void notify(DefaultMessage defaultMessage) {
        System.out.println("ob2" + defaultMessage.getData());
    }
}
