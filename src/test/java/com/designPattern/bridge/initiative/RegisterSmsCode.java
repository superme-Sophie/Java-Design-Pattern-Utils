package com.designPattern.bridge.initiative;

import com.designPattern.bridge.AbstractInitiativeAbutment;
import com.designPattern.common.InputParam;
import com.designPattern.common.OutputParam;

public class RegisterSmsCode extends AbstractInitiativeAbutment<InputParam, String, String, OutputParam> {

    private String generateCode(InputParam inputParam) {
        return "REGISTER-SMS-CODE" + inputParam;
    }

    @Override
    public String call(InputParam inputParam) {
        String code = generateCode(inputParam);
        OutputParam outputParam = another.JointPoint(code);
        if (outputParam.getOutput().equals("200 OK")) {
            return "success";
        }
        return "fail";
    }
}
