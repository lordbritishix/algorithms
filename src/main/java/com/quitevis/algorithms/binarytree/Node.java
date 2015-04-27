package com.quitevis.algorithms.binarytree;

/**
 * Created by lordbritishix on 26/04/15.
 */
public class Node {
    public Node(int value) {
        this.value = value;
    }

    //CHECKSTYLE:OFF
    public Node left;

    //CHECKSTYLE:OFF
    public Node right;

    //CHECKSTYLE:OFF
    public int value;

    @Override
    public String toString() {
        return String.valueOf(value);

    }
}
