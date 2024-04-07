package com.designPattern.chainResponsibility.impl.weighted;

import com.designPattern.chainResponsibility.ChainResponsibilityParam;
import com.designPattern.chainResponsibility.node.ChainResponsibilityNode;
import com.designPattern.chainResponsibility.node.ChainResponsibilityWeightNode;

public class ChainResponsibilityWeightedNode1 extends ChainResponsibilityWeightNode<ChainResponsibilityParam> {

    public ChainResponsibilityWeightedNode1(Integer weight) {
        super(weight);
    }

    @Override
    public void init() {

    }

    @Override
    public boolean canHandle(ChainResponsibilityParam entity) {
        return true;
    }

    @Override
    public void doHandle(ChainResponsibilityParam entity) {
        entity.setName(entity.getName() + "node1");
    }
}
