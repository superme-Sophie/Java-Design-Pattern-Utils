package com.designPattern.chainResponsibility.impl.weighted;

import com.designPattern.chainResponsibility.ChainResponsibilityParam;
import com.designPattern.chainResponsibility.node.ChainResponsibilityWeightNode;

public class ChainResponsibilityWeightedNode3 extends ChainResponsibilityWeightNode<ChainResponsibilityParam> {

    public ChainResponsibilityWeightedNode3(Integer weight) {
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
        entity.setName(entity.getName() + "node3");
    }
}
