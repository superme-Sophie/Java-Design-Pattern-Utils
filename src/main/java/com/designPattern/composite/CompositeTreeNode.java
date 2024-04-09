package com.designPattern.composite;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CompositeTreeNode {

    private final List<CompositeTreeNode> children = new ArrayList<>();
    private CompositeTreeNode parent;

    public void appendChildren(CompositeTreeNode compositeTreeNode) {
        compositeTreeNode.parent = this;
        this.children.add(compositeTreeNode);
    }

}
