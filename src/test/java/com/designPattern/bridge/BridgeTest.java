package com.designPattern.bridge;

import com.designPattern.bridge.enums.SendType;
import com.designPattern.bridge.enums.SmsCodeType;
import com.designPattern.common.InputParam;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    private final static SendSmsCodeBridgeManager manager = new SendSmsCodeBridgeManager();

    @Test
    public void test(){
        System.out.println(manager.bridge(SendType.email, SmsCodeType.login, new InputParam("what can i say?")));
        System.out.println(manager.bridge(SendType.telephone, SmsCodeType.login, new InputParam("what can i say?")));
        System.out.println(manager.bridge(SendType.email, SmsCodeType.register, new InputParam("what can i say?")));
        System.out.println(manager.bridge(SendType.telephone, SmsCodeType.register, new InputParam("what can i say?")));
    }
}
