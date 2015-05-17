package com.quitevis.algorithms.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by lordbritishix on 17/05/15.
 */
public class LinkedListTest {
    private LinkedList<String> list;

    @Before
    public void beforeEachTests() {
        list = new LinkedList<>();
    }

    @Test
    public void insertAddsCorrectNode() {
        list.insert("a");
        list.insert("b");
        list.insert("c");

        assertThat(list.toString(), is("a -> b -> c ->"));
    }

    @Test
    public void removeDuplicatesRemoveDuplicatesFromList1() {
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("a");
        list.insert("b");
        list.insert("c");

        list.removeDuplicates();

        assertThat(list.toString(), is("a -> b -> c ->"));
    }

    @Test
    public void removeDuplicatesRemoveDuplicatesFromList2() {
        list.insert("a");
        list.insert("b");
        list.insert("c");

        list.removeDuplicates();

        assertThat(list.toString(), is("a -> b -> c ->"));
    }

    @Test
    public void removeDuplicatesRemoveDuplicatesFromList3() {
        list.insert("a");
        list.insert("a");
        list.insert("a");

        list.removeDuplicates();

        assertThat(list.toString(), is("a ->"));
    }

    @Test
    public void hasCycleReturnsTrueIfListHasCycle1() {
        Node<String> n1 = new Node<>();
        Node<String> n2 = new Node<>();
        Node<String> n3 = new Node<>();

        list.insert(n1);
        list.insert(n2);
        list.insert(n3);
        list.insert(n1);

        assertThat(list.hasCycle(), is(true));
    }

    @Test
    public void hasCycleReturnsTrueIfListHasCycle2() {
        Node<String> n1 = new Node<>();

        list.insert(n1);
        list.insert(n1);

        assertThat(list.hasCycle(), is(true));
    }

    @Test
    public void hasCycleReturnsFalseIfListHasNoCycle() {
        Node<String> n1 = new Node<>();
        Node<String> n2 = new Node<>();
        Node<String> n3 = new Node<>();

        list.insert(n1);
        list.insert(n2);
        list.insert(n3);

        assertThat(list.hasCycle(), is(false));
    }
}
