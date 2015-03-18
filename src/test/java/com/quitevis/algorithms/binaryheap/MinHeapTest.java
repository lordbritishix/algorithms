package com.quitevis.algorithms.binaryheap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinHeapTest {
    Logger log = LoggerFactory.getLogger(MinHeapTest.class);

    @Test
    public void testInsertReturnsMinAtTop() {
        MinHeap heap = new MinHeap(10);
        
        heap.insert(5);
        
        assertThat(heap.peek(), is(5));
        
        heap.insert(6);
        
        assertThat(heap.peek(), is(5));

        heap.insert(3);
        
        assertThat(heap.peek(), is(3));

        heap.insert(7);
        
        assertThat(heap.peek(), is(3));

        heap.insert(1);
        
        assertThat(heap.peek(), is(1));

        heap.insert(7);
        
        assertThat(heap.peek(), is(1));
        
        assertThat(heap.getCurrentSize(), is(6));
    }
    
    @Test
    public void testPopReturnsNextMinAtTop() {
        MinHeap heap = new MinHeap(10);
        
        for (int x = 0; x < 10; ++x) {
            heap.insert(x);
        }
        
        assertThat(heap.peek(), is(0));

        heap.pop();
        assertThat(heap.peek(), is(1));

        heap.pop();
        assertThat(heap.peek(), is(2));

        heap.pop();
        assertThat(heap.peek(), is(3));

        heap.pop();
        assertThat(heap.peek(), is(4));
        
        heap.pop();
        assertThat(heap.peek(), is(5));

        heap.pop();
        assertThat(heap.peek(), is(6));
        
        heap.pop();
        assertThat(heap.peek(), is(7));
        
        heap.pop();
        assertThat(heap.peek(), is(8));
        
        heap.pop();
        assertThat(heap.peek(), is(9));
    }
    
    @Test
    public void testPopAndInsertReturnsNextMinAtTop() {
        MinHeap heap = new MinHeap(10);
        
        heap.insert(1);
        heap.insert(2);
        
        heap.pop();
        assertThat(heap.peek(), is(2));
        
        heap.insert(1000);
        assertThat(heap.peek(), is(2));

        heap.pop();
        assertThat(heap.peek(), is(1000));
    }

}
