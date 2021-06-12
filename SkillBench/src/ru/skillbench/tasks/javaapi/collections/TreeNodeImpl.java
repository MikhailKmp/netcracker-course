package ru.skillbench.tasks.javaapi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNodeImpl implements TreeNode {

    private Object data;
    private boolean expanded = false;
    private TreeNode parent;
    private List<TreeNode> children;

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        if (parent == null) {
            return null;
        }
        TreeNode root = parent;
        while (root.getParent() != null) {
            root = root.getParent();
        }
        return root;
    }

    @Override
    public boolean isLeaf() {
        if (children != null && !children.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return children.iterator();
    }

    @Override
    public void addChild(TreeNode child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
        child.setParent(this);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        Iterator<TreeNode> iterator = getChildrenIterator();
        while (iterator.hasNext()) {
            TreeNode treeNode = iterator.next();
            if (child.equals(treeNode)) {
                iterator.remove();
                child.setParent(null);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isExpanded() {
        return !expanded ? false : true;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        for (TreeNode treeNode : children) {
            treeNode.setExpanded(expanded);
        }
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getTreePath() {
        String string = "";

        TreeNode treeNode = this;
        while (treeNode.getParent() != null) {
            Object object = treeNode.getData();
            string = object == null ? "->empty" + string : "->" + object + string;
            treeNode = treeNode.getParent();
        }

        Object object = treeNode.getData();
        string = object == null ? "empty" + string : object + string;
        return string;
    }

    @Override
    public TreeNode findParent(Object data) {
        TreeNode treeNode = this;
        while (true) {
            if (treeNode.getData() == null && data == null || treeNode.getData() != null && treeNode.getData().equals(data)) {
                return treeNode;
            }
            if (treeNode.getParent() == null) {
                return null;
            }
            treeNode = treeNode.getParent();
        }
    }

    @Override
    public TreeNode findChild(Object data) {
        TreeNode treeNode;
        if (children == null || children.isEmpty()) {
            return null;
        }
        for (TreeNode temp : children) {
            if (temp.getData() == null && data == null || temp.getData() != null && temp.getData().equals(data)) {
                return temp;
            }
        }
        for (TreeNode temp : children) {
            treeNode = temp.findChild(data);
            if (treeNode != null) {
                return treeNode;
            }
        }
        return null;
    }
}