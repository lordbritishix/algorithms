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

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();

        Node ptr = this;

        buf.append(value);
        buf.append(" -> ");

        while (ptr != null) {
            buf.append(ptr.value);
            buf.append(", ");
            ptr = ptr.next;
        }

        return buf.toString().trim();
    }
}
