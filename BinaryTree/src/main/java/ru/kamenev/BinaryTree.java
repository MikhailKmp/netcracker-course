package ru.kamenev;

import java.util.NoSuchElementException;

/**
 * Класс, который представляет из себя сущность бинарное дерево
 */
public class BinaryTree {

    /** Корень дерева */
    private TreeNode root;

    public BinaryTree(){}

    /**
     * Метод ищет узел по ключу и возвращает его. Если узла с таким ключом нет,
     * то генерируется исключение NoSuchElementException
     * @param key ключ узла, по которому осуществляется поиск
     * @return узел
     */
    public TreeNode find(int key) {
        return findRecursively(root, key);
    }

    /**
     * Приватный метод для рекурсивного поиска узла по ключу.
     * @param node узел, в поддереве которого будет осуществляться рекурсивный поиск.
     * @param key ключ узла, по которому осуществляется поиск
     * @return узел
     */
    private TreeNode findRecursively(TreeNode node, int key) {
        if (node == null) {
            throw new NoSuchElementException();
        }
        else if (key == node.key) {
            return node;
        }
        return key < node.key ? findRecursively(node.leftNode, key) : findRecursively(node.rightNode, key);
    }

    /**
     * Метод, который оуществляет добавление узла в дерево
     * @param key ключ узла
     * @param data значение узла
     */
    public void insert(int key, Object data) {
        root = insertRecursively(root, key, data);
    }

    /**
     * Приватный метод для рекурсивного добавления узла
     * (метод ищет место для узла и вставляет его)
     * @param node узел, в поддереве которого будет осуществляться рекурсивное добавление
     * @param key ключ узла, который надо добавить
     * @param data значение узла, которое надо добавить
     * @return узел с обновленным поддеревом
     */
    private TreeNode insertRecursively(TreeNode node, int key, Object data) {
        if (node == null) {
            return new TreeNode(key, data);
        }
        else if (key < node.key) {
            node.leftNode = insertRecursively(node.leftNode, key, data);
        }
        else if (key > node.key) {
            node.rightNode = insertRecursively(node.rightNode, key, data);
        }
        return node;
    }

    /**
     * Метод, который осуществляет удаление узла по его ключу
     * @param key
     */
    public void remove(int key) {
        removeRecursively(root, key);
    }

    /**
     * Приватный метод для рекурсивного удаления узла
     * @param node узел, в поддереве которого будет осуществляться
     *             поиск и удаление узла
     * @param key ключ узла, который надо удалить
     * @return узел с обновленным поддеревом
     */
    private TreeNode removeRecursively(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        else if (key < node.key) {
            node.leftNode = removeRecursively(node.leftNode, key);
        }
        else if (key > node.key) {
            node.rightNode = removeRecursively(node.rightNode, key);
        }
        else {
            if (node.leftNode == null && node.rightNode == null) {
                return null;
            }
            else if (node.leftNode == null) {
                return node.rightNode;
            }
            else if (node.rightNode == null) {
                return node.leftNode;
            }
            else {
                TreeNode smallestNode = findSmallestNode(node.rightNode);
                node.key = smallestNode.key;
                node.data = smallestNode.data;
                node.rightNode = removeRecursively(node.rightNode, smallestNode.key);
                return node;
            }
        }
        return node;
    }

    /**
     * Метод возвращает самый маленький узел в поддереве данного узла
     * @param node узел, в поддереве которого будет осуществляться поиск
     * @return самый маленький узел
     */
    private TreeNode findSmallestNode(TreeNode node) {
        return node.leftNode == null ? node : findSmallestNode(node);
    }

    /**
     * Метод осуществляет центрированный обход дерева
     * и выводит значения узлов в консоль
     */
    public void centeredTraversal() {
        centeredTraversalRecursively(root);
        System.out.println();
    }

    /**
     * Рекурсивный метод для центрированного обхода дерева
     * и вывода значения узлов в консоль
     * @param node узел, в поддереве которого необходимо выполнить
     *             центрированный обход
     */
    private void centeredTraversalRecursively(TreeNode node) {
        if (node != null) {
            centeredTraversalRecursively(node.leftNode);
            System.out.print(node.data + " ");
            centeredTraversalRecursively(node.rightNode);
        }
    }

    /**
     * Метод осуществляет прямой обход дерева
     * и выводит значения узлов в консоль
     */
    public void directTraversal() {
        directTraversalRecursively(root);
        System.out.println();
    }

    /**
     * Рекурсивный метод для прямого обхода дерева
     * и вывода значения узлов в консоль
     * @param node узел, в поддереве которого необходимо выполнить
     *             прямой обход
     */
    private void directTraversalRecursively(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            directTraversalRecursively(node.leftNode);
            directTraversalRecursively(node.rightNode);
        }
    }

    /**
     * Метод осуществляет обратный обход дерева
     * и выводит значения узлов в консоль
     */
    public void reverseTraversal() {
        reverseTraversalRecursively(root);
        System.out.println();
    }

    /**
     * Рекурсивный метод для обратного обхода дерева
     * и вывода значения узлов в консоль
     * @param node узел, в поддереве которого необходимо выполнить
     *             обратный обход
     */
    private void reverseTraversalRecursively(TreeNode node) {
        if (node != null) {
            reverseTraversalRecursively(node.leftNode);
            reverseTraversalRecursively(node.rightNode);
            System.out.print(node.data + " ");
        }
    }

    /**
     * Метод возвращает глубину дерева
     * @return глубина дерева
     */
    public int getDepth() {
        return getDepthRecursively(root);
    }

    /**
     * Рекурсивный метод для расчета глубины дерева
     * @param node узел, глубину которого необходимо рассчитать
     * @return глубина узла
     */
    private int getDepthRecursively(TreeNode node) {
        if (node == null || node.leftNode == null && node.rightNode == null) {
            return 0;
        }
        return 1 + Math.max(getDepthRecursively(node.leftNode), getDepthRecursively(node.rightNode));
    }

    /**
     * Класс, который представляет из себя сузность узла
     * бинарного дерева
     */
    private class TreeNode {
        private int key;
        private Object data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(int key, Object data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "key=" + key +
                    ", data=" + data +
                    '}';
        }
    }
}