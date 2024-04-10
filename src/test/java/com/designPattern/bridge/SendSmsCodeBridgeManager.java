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

public class SendSmsCodeBridgeManager extends AbstractBridgeManager<InputParam, String, String, OutputParam, SmsCodeType, SendType> {

    @Override
    protected Map<SendType, AbstractPassivityAbutment<String, OutputParam>> passivityAbutmentInstance() {
        return new HashMap<SendType, AbstractPassivityAbutment<String, OutputParam>>() {{
            put(SendType.email, new EmailSink());
            put(SendType.telephone, new TelephoneSink());
        }};
    }

    @Override
    protected Map<SmsCodeType, AbstractInitiativeAbutment<InputParam, String, String, OutputParam>> initiativeAbutmentInstance() {
        return new HashMap<SmsCodeType, AbstractInitiativeAbutment<InputParam, String, String, OutputParam>>() {{
            put(SmsCodeType.login, new LoginSmsCode());
            put(SmsCodeType.register, new RegisterSmsCode());
        }};
    }

}
