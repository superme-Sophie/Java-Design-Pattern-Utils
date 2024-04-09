package com.designPattern.composite;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CompositeTreeTest {

    private final static CompositeTree<CompositeTreeNode> COMPOSITE_TREE = new CompositeTree<>();
    private final static List<TreeNode> list = new ArrayList<>();

    static {
        CompositeTreeNode compositeTreeNode = new CompositeTreeNode();
        CompositeTreeNode compositeTreeNode2 = new CompositeTreeNode();
        COMPOSITE_TREE.appendChildren(COMPOSITE_TREE.getRoot(), compositeTreeNode);
        COMPOSITE_TREE.appendChildren(compositeTreeNode, compositeTreeNode2);

        list.add(new TreeNode("0","-1","TreeNode1"));
        list.add(new TreeNode("1","-1","TreeNode2"));
        list.add(new TreeNode("2","-1","TreeNode3"));
        list.add(new TreeNode("3","2","TreeNode4"));
        list.add(new TreeNode("4","1","TreeNode5"));
    }

    @Test
    public void test() {
        CompositeTreeNode root = COMPOSITE_TREE.getRoot();
        List<CompositeTreeNode> children = root.getChildren();
        List<CompositeTreeNode> nodeList = children.get(0).getChildren();
        System.out.println(nodeList);
    }

    @Test
    public void testTransfer() {
        CompositeTree.transferListToTree(list, "id", "pId").bfsPrint();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @RequiredArgsConstructor
    @ToString
    private static class TreeNode extends CompositeTreeNode {

        private final String id;
        private final String pId;
        private final String name;

    }
}
