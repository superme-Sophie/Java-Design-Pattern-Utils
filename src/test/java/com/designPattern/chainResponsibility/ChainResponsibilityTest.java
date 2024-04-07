package com.designPattern.chainResponsibility;

import com.designPattern.chainResponsibility.enums.ExecutionMode;
import com.designPattern.chainResponsibility.enums.SequenceMode;
import com.designPattern.chainResponsibility.impl.common.ChainResponsibilityNode1;
import com.designPattern.chainResponsibility.impl.common.ChainResponsibilityNode2;
import com.designPattern.chainResponsibility.impl.common.ChainResponsibilityNode3;
import org.junit.jupiter.api.Test;


public class ChainResponsibilityTest {

    @Test
    public void generate(){
        ChainResponsibility<ChainResponsibilityParam> responsibility = new ChainResponsibility<>();
        ChainResponsibility<ChainResponsibilityParam> chain = responsibility
                .insert(new ChainResponsibilityNode1())
                .insert(new ChainResponsibilityNode2())
                .insert(new ChainResponsibilityNode3());

        // 从头到尾 一次
        chain.handle(new ChainResponsibilityParam()).assertParam("node1").log();

        // 从尾到头 一次
        chain.order(SequenceMode.Reverse);
        chain.handle(new ChainResponsibilityParam()).assertParam("node3").log();

        // 从尾到头 全流程
        chain.handleMode(ExecutionMode.CompleteFlow);
        chain.handle(new ChainResponsibilityParam()).assertParam("node3node2node1").log();

        // 从头到尾 全流程
        chain.order(SequenceMode.Sequential);
        chain.handle(new ChainResponsibilityParam()).assertParam("node1node2node3").log();
    }
}
