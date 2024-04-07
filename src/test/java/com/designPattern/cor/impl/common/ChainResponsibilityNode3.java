package com.designPattern.cor.impl.common;

import com.designPattern.cor.ChainResponsibilityParam;
import com.designPattern.cor.node.ChainResponsibilityNode;

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
