package ru.kamenev;

public class Main {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(8, 8);
        binaryTree.insert(3, 3);
        binaryTree.insert(10, 10);
        binaryTree.insert(1, 1);
        binaryTree.insert(6, 6);
        binaryTree.insert(4, 4);
        binaryTree.insert(7, 7);
        binaryTree.insert(14, 14);
        binaryTree.insert(13, 13);

        System.out.print("Центрированный обход: ");
        binaryTree.centeredTraversal();

        System.out.print("Прямой обход: ");
        binaryTree.directTraversal();

        System.out.print("Обратный обход: ");
        binaryTree.reverseTraversal();

        System.out.println("Глубина дерева: " + binaryTree.getDepth());

        //удаляем узел с ключом 4 и выводим дерево
        binaryTree.remove(4);
        System.out.print("Дерево после удаления узла с ключом 4: ");
        binaryTree.centeredTraversal();

        System.out.println("Узел 6: " + binaryTree.find(6));

        binaryTree.remove(7);
        binaryTree.remove(13);
        System.out.println("Глубина дерева после удаления узлов с ключами 7 и 13: " + binaryTree.getDepth());
    }
}