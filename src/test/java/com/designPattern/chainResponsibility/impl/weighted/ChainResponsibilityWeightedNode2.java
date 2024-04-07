package com.designPattern.chainResponsibility.impl.weighted;

import com.designPattern.chainResponsibility.ChainResponsibilityParam;
import com.designPattern.chainResponsibility.node.ChainResponsibilityWeightNode;

public class ChainResponsibilityWeightedNode2 extends ChainResponsibilityWeightNode<ChainResponsibilityParam> {

    public ChainResponsibilityWeightedNode2(Integer weight) {
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
        entity.setName(entity.getName() + "node2");
    }
}
