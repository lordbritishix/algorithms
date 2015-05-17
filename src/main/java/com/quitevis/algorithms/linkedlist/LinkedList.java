package com.quitevis.algorithms.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lordbritishix on 17/05/15.
 */
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void insert(T value) {
        Node<T> node = new Node<>();
        node.value = value;

        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }

    public void insert(Node<T> node) {
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }


    public void removeDuplicates() {
        Set<T> lookup = new HashSet<>();

        Node<T> ptr = head;
        Node<T> prev = head;
        while (ptr != null) {
            if (!lookup.add(ptr.value)) {
                prev.next = ptr.next;
                ptr = ptr.next;
            }
            else {
                prev = ptr;
                ptr = ptr.next;
            }
        }
    }

    public boolean hasCycle() {
        Node<T> ptr = head;
        boolean hasCycle = false;

        Set<Node<T>> lookup = new HashSet<>();

        while ((ptr != null) && (!hasCycle)) {
            if (!lookup.add(ptr)) {
                hasCycle = true;
            }
            else {
                ptr = ptr.next;
            }
        }

        return hasCycle;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        Node ptr = head;

        while (ptr != null) {
            ret.append(ptr.value.toString());
            ret.append(" -> ");
            ptr = ptr.next;
        }

        return ret.toString().trim();
    }
}
