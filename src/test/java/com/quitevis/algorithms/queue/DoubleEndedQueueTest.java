package com.quitevis.algorithms.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DoubleEndedQueueTest {
    private Deque<String> random = new Deque<String>();

    @Before
    public void beforeEachTests() {
        random = new Deque<String>();
    }

    @Test
    public void testAddLast() {
        random.addLast("Hey");
        random.addLast("There");

        assertThat(random.toString(), is("Hey,There"));
    }

    @Test
    public void addFirstAddsItemToStartOfContainer() {
        random.addFirst("Hey");
        random.addFirst("There");

        assertThat(random.toString(), is("There,Hey"));
    }

    @Test
    public void addFirstAndLastAddsItemToCorrectPosition() {
        random.addFirst("Hey");
        random.addFirst("There");
        random.addLast("Ma");

        assertThat(random.toString(), is("There,Hey,Ma"));
    }

    @Test
    public void removeLastRemovesLastItemFromContainer() {
        random.addLast("Hey");
        random.addLast("There");
        random.addLast("Ma");

        assertThat(random.removeLast(), is("Ma"));
        assertThat(random.toString(), is("Hey,There"));
        assertThat(random.removeLast(), is("There"));
        assertThat(random.toString(), is("Hey"));
        assertThat(random.removeLast(), is("Hey"));
        assertThat(random.toString(), is(""));
    }

    @Test
    public void removeFirstRemovesFirstItemFromContainer() {
        random.addLast("Hey");
        random.addLast("There");
        random.addLast("Ma");

        assertThat(random.removeFirst(), is("Hey"));
        assertThat(random.toString(), is("There,Ma"));
        assertThat(random.removeFirst(), is("There"));
        assertThat(random.toString(), is("Ma"));
        assertThat(random.removeFirst(), is("Ma"));
        assertThat(random.toString(), is(""));
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstIfContainerIsEmptyThrowsException1() {
        random.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstIfContainerIsEmptyThrowsException2() {
        random.addLast("Hey");

        random.removeFirst();
        random.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastIfContainerIsEmptyThrowsException1() {

        random.removeLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastIfContainerIsEmptyThrowsException2() {
        Deque<String> random = new Deque<String>();
        random.addLast("Hey");

        random.removeLast();
        random.removeLast();
    }


    @Test
    public void sizeReturnsCorrectSize() {
        assertThat(random.size(), is(0));

        random.addFirst("Hey");
        random.addFirst("There");
        random.addLast("Ma");

        assertThat(random.size(), is(3));

        random.removeFirst();
        random.removeFirst();
        random.removeFirst();

        assertThat(random.size(), is(0));
    }


    @Test(expected = NoSuchElementException.class)
    public void iteratorThrowsExceptionWhenNoMoreElements() {
        random.addFirst("Hey");
        random.addFirst("There");

        Iterator<String> iter = random.iterator();

        iter.next();
        iter.next();
        iter.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorThrowsExceptionWhenEmpty() {
        Iterator<String> iter = random.iterator();

        iter.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorThrowsExceptionWhenRemove() {
        Iterator<String> iter = random.iterator();

        iter.remove();
    }

    @Test
    public void isEmptyReturnsCorrectResult() {
        assertThat(random.isEmpty(), is(true));
        random.addLast("Hey");

        assertThat(random.isEmpty(), is(false));

        random.removeFirst();

        assertThat(random.isEmpty(), is(true));
    }
}
