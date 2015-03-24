package com.quitevis.algorithms.bst;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }

    public void setLeft(Node node) {
        left = node;
    }

    public void setRight(Node node) {
        right = node;
    }
}
