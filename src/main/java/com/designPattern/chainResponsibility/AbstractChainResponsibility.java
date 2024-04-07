package com.designPattern.chainResponsibility;

import com.designPattern.chainResponsibility.node.AbstractChainResponsibilityNode;
import com.designPattern.chainResponsibility.node.ChainResponsibilityNode;

public abstract class AbstractChainResponsibility<Node extends AbstractChainResponsibilityNode<Param>, Param> {

    protected Node head;
    protected Node tail;

    protected abstract AbstractChainResponsibility<Node, Param> insert(Node node);

    protected abstract Param handle(Param entity);

    public void print() {
        Node curr = head;
        StringBuilder builder = new StringBuilder();
        while (curr != null) {
            builder.append(curr.getClass().getName()).append("->");
            curr = (Node) curr.next;
        }
        System.out.println(builder);
    }
}
