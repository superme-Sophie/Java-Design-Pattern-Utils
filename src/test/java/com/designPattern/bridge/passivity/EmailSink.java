package com.designPattern.bridge.passivity;

import com.designPattern.bridge.AbstractPassivityAbutment;
import com.designPattern.common.OutputParam;

public class EmailSink extends AbstractPassivityAbutment<String, OutputParam> {

    @Override
    public OutputParam JointPoint(String inputParam) {
        System.out.println("发送到邮箱, 验证码类型为: " + inputParam);
        return new OutputParam("200 OK");
    }
}
