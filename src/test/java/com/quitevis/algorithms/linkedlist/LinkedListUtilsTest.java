package com.quitevis.algorithms.linkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lordbritishix on 25/05/15.
 */
public class LinkedListUtilsTest {
    private LinkedListUtils<Integer> linkedListUtils;

    private class IntegerComparator implements Comparator<Node<Integer>> {
        @Override
        public int compare(Node<Integer> o1, Node<Integer> o2) {
            return o1.value.compareTo(o2.value);
        }
    }

    @Before
    public void beforeEachTest() {
        linkedListUtils = new LinkedListUtils<>();
    }

    @Test
    public void mergeSortedListsMergesTwoSortedLists1() {
        Node<Integer> m1 = new Node<>(1);
        Node<Integer> m2 = new Node<>(2);
        Node<Integer> m3 = new Node<>(3);
        Node<Integer> m4 = new Node<>(4);
        Node<Integer> m5 = new Node<>(5);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;

        Node<Integer> ret = linkedListUtils.mergeSortedLists(m1, null, new IntegerComparator());

        assertThat(linkedListUtils.getString(ret), is("1, 2, 3, 4, 5,"));
    }

    @Test
    public void mergeSortedListsMergesTwoSortedLists2() {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node<Integer> ret = linkedListUtils.mergeSortedLists(null, n1, new IntegerComparator());

        assertThat(linkedListUtils.getString(ret), is("1, 2, 3, 4, 5,"));
    }

    @Test
    public void mergeSortedListsMergesTwoSortedLists3() {
        Node<Integer> m1 = new Node<>(0);
        Node<Integer> m2 = new Node<>(1);
        Node<Integer> m3 = new Node<>(6);
        Node<Integer> m4 = new Node<>(7);
        Node<Integer> m5 = new Node<>(8);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;

        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(3);
        Node<Integer> n3 = new Node<>(4);
        Node<Integer> n4 = new Node<>(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node<Integer> ret = linkedListUtils.mergeSortedLists(m1, n1, new IntegerComparator());

        assertThat(linkedListUtils.getString(ret), is("0, 1, 2, 3, 4, 5, 6, 7, 8,"));
    }

    @Test
    public void mergeSortedListsMergesTwoSortedLists4() {
        Node<Integer> ret = linkedListUtils.mergeSortedLists(null, null, new IntegerComparator());

        assertThat(linkedListUtils.getString(ret), is(""));
    }

    @Test
    public void mergeSortedListsMergesTwoSortedLists5() {
        Node<Integer> m1 = new Node<>(0);
        Node<Integer> m2 = new Node<>(1);
        Node<Integer> m3 = new Node<>(6);
        Node<Integer> m4 = new Node<>(7);
        Node<Integer> m5 = new Node<>(8);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;

        Node<Integer> n1 = new Node<>(2);

        Node<Integer> ret = linkedListUtils.mergeSortedLists(m1, n1, new IntegerComparator());

        assertThat(linkedListUtils.getString(ret), is("0, 1, 2, 6, 7, 8,"));
    }
}
