package com.designPattern.chainResponsibility.impl.common;

import com.designPattern.chainResponsibility.ChainResponsibilityParam;
import com.designPattern.chainResponsibility.node.ChainResponsibilityNode;

public class ChainResponsibilityNode3 extends ChainResponsibilityNode<ChainResponsibilityParam> {
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
