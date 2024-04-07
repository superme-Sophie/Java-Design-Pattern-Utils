package com.designPattern.chainResponsibility;

import com.designPattern.chainResponsibility.enums.ExecutionMode;
import com.designPattern.chainResponsibility.enums.WeightedMode;
import com.designPattern.chainResponsibility.impl.weighted.ChainResponsibilityWeightedNode1;
import com.designPattern.chainResponsibility.impl.weighted.ChainResponsibilityWeightedNode2;
import com.designPattern.chainResponsibility.impl.weighted.ChainResponsibilityWeightedNode3;
import org.junit.jupiter.api.Test;


public class ChainResponsibilityWeightedTest {

    @Test
    public void test(){
        WeightedChainResponsibility<ChainResponsibilityParam> responsibility = new WeightedChainResponsibility<>();
        WeightedChainResponsibility<ChainResponsibilityParam> chain = responsibility
                .insert(new ChainResponsibilityWeightedNode1(10))
                .insert(new ChainResponsibilityWeightedNode2(1000))
                .insert(new ChainResponsibilityWeightedNode3(1));

        chain.print();

        // 重->轻 一次
        chain.handle(new ChainResponsibilityParam()).assertParam("node2").log();

        // 轻->重 一次
        chain.weightedMode(WeightedMode.LighterFirst);
        chain.handle(new ChainResponsibilityParam()).assertParam("node3").log();

        // 轻->重 全流程
        chain.executionMode(ExecutionMode.CompleteFlow);
        chain.handle(new ChainResponsibilityParam()).assertParam("node3node1node2").log();

        // 重到轻 全流程
        chain.weightedMode(WeightedMode.HeavierFirst);
        chain.handle(new ChainResponsibilityParam()).assertParam("node2node1node3").log();
    }
}
