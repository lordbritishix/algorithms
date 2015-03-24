package com.quitevis.algorithms.binaryheap;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxHeapTest {
    Logger log = LoggerFactory.getLogger(MaxHeapTest.class);

    @Before
    public void beforeEachTests() {
    }

    @Test
    public void initializationReturnsCorrectSize() {
        MaxHeap heap = new MaxHeap(10);
        assertThat(heap.getMaxSize(), is(10));
    }

    @Test(expected = NoSuchElementException.class)
    public void popOnEmptyHeapThrowsException() throws NoSuchAlgorithmException {
        MaxHeap heap = new MaxHeap(10);
        heap.pop();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertOnFullHeapThrowsException() throws IndexOutOfBoundsException {
        MaxHeap heap = new MaxHeap(5);

        for (int x = 0; x < 6; ++x) {
            heap.insert(x);
        }
    }

    @Test
    public void testInsertReturnsMaxAtTop() {
        MaxHeap heap = new MaxHeap(10);

        heap.insert(5);

        assertThat(heap.peek(), is(5));

        heap.insert(6);

        assertThat(heap.peek(), is(6));

        heap.insert(3);

        assertThat(heap.peek(), is(6));

        heap.insert(7);

        assertThat(heap.peek(), is(7));

        heap.insert(1);

        assertThat(heap.peek(), is(7));

        heap.insert(7);

        assertThat(heap.peek(), is(7));

        assertThat(heap.getCurrentSize(), is(6));
    }

    @Test
    public void testPopReturnsNextMaxAtTop() {
        MaxHeap heap = new MaxHeap(10);

        for (int x = 0; x < 10; ++x) {
            heap.insert(x);
        }

        assertThat(heap.peek(), is(9));

        heap.pop();
        assertThat(heap.peek(), is(8));

        heap.pop();
        assertThat(heap.peek(), is(7));

        heap.pop();
        assertThat(heap.peek(), is(6));

        heap.pop();
        assertThat(heap.peek(), is(5));

        heap.pop();
        assertThat(heap.peek(), is(4));

        heap.pop();
        assertThat(heap.peek(), is(3));

        heap.pop();
        assertThat(heap.peek(), is(2));

        heap.pop();
        assertThat(heap.peek(), is(1));

        heap.pop();
        assertThat(heap.peek(), is(0));
    }

    @Test
    public void testPopAndInsertReturnsNextMaxAtTop() {
        MaxHeap heap = new MaxHeap(10);

        heap.insert(1);
        heap.insert(2);

        heap.pop();
        assertThat(heap.peek(), is(1));

        heap.insert(1000);
        assertThat(heap.peek(), is(1000));

        heap.pop();
        assertThat(heap.peek(), is(1));
    }
}
