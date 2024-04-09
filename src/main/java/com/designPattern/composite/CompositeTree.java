package com.designPattern.composite;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 组合模式
 * 父子树工具
 */
@Getter
@Slf4j
public class CompositeTree<N extends CompositeTreeNode> {

    private final CompositeTreeNode root = new CompositeTreeNode();

    public CompositeTree() {

    }

    public void appendChildren(N parent, N child) {
        parent.appendChildren(child);
    }


    private static Object getFieldValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    /**
     * 将指定列表转为树状结构
     */
    public static <N extends CompositeTreeNode> CompositeTree<N> transferListToTree(List<N> nodes, String idFieldName, String pidFieldName) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        CompositeTree<N> compositeTree = new CompositeTree<>();
        CompositeTreeNode root = compositeTree.getRoot();
        Map<String, N> nodeMap = new HashMap<>();
        try {
            for (N node : nodes) {
                nodeMap.put((String) getFieldValue(node, idFieldName), node);
            }
            for (N node : nodes) {
                String pid = (String) getFieldValue(node, pidFieldName);
                N parentNode = nodeMap.get(pid);
                if (parentNode != null) {
                    parentNode.appendChildren(node);
                } else {
                    root.appendChildren(node);
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.error("传入的id或pid字段异常", e);
        }
        return compositeTree;
    }

    public void bfsPrint() {
        ArrayDeque<CompositeTreeNode> nextNodes = new ArrayDeque<>();
        ArrayDeque<CompositeTreeNode> currNodes = new ArrayDeque<>();
        currNodes.addLast(root);
        while (!currNodes.isEmpty()) {
            CompositeTreeNode curr = currNodes.pop();
            if (!curr.getChildren().isEmpty()) {
                nextNodes.addAll(curr.getChildren());
            }
            log.info("bfs node -> {}", curr);
            if (currNodes.isEmpty() && !nextNodes.isEmpty()) {
                currNodes.addAll(nextNodes);
                nextNodes.clear();
            }
        }
    }

}
