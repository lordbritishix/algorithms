package com.quitevis.algorithms.linkedlist;

/**
 * Created by lordbritishix on 17/05/15.
 */
public class Node<T> {
    //CHECKSTYLE:OFF
    public Node next;

    //CHECKSTYLE:OFF
    public T value;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }
}
