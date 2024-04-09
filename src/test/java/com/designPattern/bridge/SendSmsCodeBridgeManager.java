package com.designPattern.bridge;

import com.designPattern.bridge.enums.SendType;
import com.designPattern.bridge.enums.SmsCodeType;
import com.designPattern.bridge.initiative.LoginSmsCode;
import com.designPattern.bridge.initiative.RegisterSmsCode;
import com.designPattern.bridge.passivity.EmailSink;
import com.designPattern.bridge.passivity.TelephoneSink;
import com.designPattern.common.InputParam;
import com.designPattern.common.OutputParam;

import java.util.HashMap;
import java.util.Map;

public class SendSmsCodeBridgeManager extends AbstractBridgeManager<InputParam, OutputParam, String, String, SendType, SmsCodeType> {

    @Override
    protected Map<SendType, AbstractPassivityAbutment<String, OutputParam>> passivityAbutmentInstance() {
        return new HashMap<SendType, AbstractPassivityAbutment<String, OutputParam>>() {{
            put(SendType.email, new EmailSink());
            put(SendType.telephone, new TelephoneSink());
        }};
    }

    @Override
    protected Map<SmsCodeType, AbstractInitiativeAbutment<InputParam, OutputParam, String, String>> initiativeAbutmentInstance() {
        return new HashMap<SmsCodeType, AbstractInitiativeAbutment<InputParam, OutputParam, String, String>>() {{
            put(SmsCodeType.login, new LoginSmsCode());
            put(SmsCodeType.register, new RegisterSmsCode());
        }};
    }

}
