package com.quitevis.algorithms.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

/**
 * Created by lordbritishix on 25/05/15.
 */
public class LinkedListUtils<T> {
    private Logger log = LoggerFactory.getLogger(LinkedListUtils.class);

    public Node<T> mergeSortedLists(Node<T> m, Node<T> n, Comparator<Node<T>> comparator) {
        Node<T> mPtr = m;
        Node<T> nPtr = n;
        Node<T> newHead = null;
        Node<T> newHeadPtr = null;

        while ((mPtr != null) || (nPtr != null)) {
            if (mPtr == null) {
                if (newHead == null) {
                    newHead = nPtr;
                    newHeadPtr = newHead;
                }
                else {
                    newHeadPtr.next = nPtr;
                    newHeadPtr = nPtr;
                }

                nPtr = nPtr.next;
            } else if (nPtr == null) {
                if (newHead == null) {
                    newHead = mPtr;
                    newHeadPtr = newHead;
                }
                else {
                    newHeadPtr.next = mPtr;
                    newHeadPtr = mPtr;
                }

                mPtr = mPtr.next;
            } else {
                log.trace("Comparing: {}, {}", mPtr.value, nPtr.value);
                if (comparator.compare(mPtr, nPtr) > 0) {
                    if (newHead == null) {
                        newHead = nPtr;
                        newHeadPtr = newHead;
                    }
                    else {
                        newHeadPtr.next = nPtr;
                        newHeadPtr = newHeadPtr.next;
                    }
                    nPtr = nPtr.next;
                }
                else {
                    if (newHead == null) {
                        newHead = mPtr;
                        newHeadPtr = newHead;
                    }
                    else {
                        newHeadPtr.next = mPtr;
                        newHeadPtr = newHeadPtr.next;
                    }
                    mPtr = mPtr.next;
                }
            }
        }

        return newHead;
    }


    public String getString(Node<T> node) {
        StringBuffer ret = new StringBuffer();

        Node<T> ptr = node;

        while (ptr != null) {
            ret.append(ptr.value);
            ret.append(", ");
            ptr = ptr.next;
        }

        return ret.toString().trim();
    }
}
