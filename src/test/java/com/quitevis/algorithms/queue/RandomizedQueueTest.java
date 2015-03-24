package com.quitevis.algorithms.queue;

import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class RandomizedQueueTest {
    private RandomizedQueue<String> queue;

    @Before
    public void beforeEachTests() {
        queue = new RandomizedQueue<String>();
    }

    @Test
    public void sizeReturnsCorrectSize() {
        assertThat(queue.size(), is(0));

        queue.enqueue("Hey");
        queue.enqueue("There");
        queue.enqueue("Ma");

        assertThat(queue.size(), is(3));

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertThat(queue.size(), is(0));
    }

    @Test
    public void sampleReturnsRandomElement() {
        HashSet<String> data = Sets.newHashSet();
        data.add("Hey");
        data.add("There");
        data.add("Ma");

        for (String str : data) {
            queue.enqueue(str);
        }

        for (int x = 0; x < 100; ++x) {
            assertThat(queue.sample(), isIn(data));
        }
    }


    @Test
    public void dequeueReturnsRandomElement() {
        HashSet<String> data = Sets.newHashSet();
        data.add("Hey");
        data.add("There");
        data.add("Ma");

        for (String str : data) {
            queue.enqueue(str);
        }

        String result = "";

        result = queue.dequeue();
        assertThat(result, isIn(data.toArray()));
        data.remove(result);

        result = queue.dequeue();
        assertThat(result, isIn(data.toArray()));
        data.remove(result);

        result = queue.dequeue();
        assertThat(result, isIn(data.toArray()));
        data.remove(result);
    }


    @Test
    public void emptyReturnsCorrectResult() {
        assertThat(queue.isEmpty(), is(true));
        queue.enqueue("Hey");
        assertThat(queue.isEmpty(), is(false));
        queue.dequeue();
        assertThat(queue.isEmpty(), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeueIfEmptyThrowsException() {
        queue.dequeue();
    }

    @Test
    public void iteratorReturnsRandomNext() {
        StringBuffer buf = new StringBuffer();
        for (int x = 0; x < 100; ++x) {
            queue.enqueue(String.valueOf(x));
            buf.append(x);
            buf.append(",");
        }

        String result = buf.substring(0, buf.length() - 1);
        assertThat(result, not(queue.toString()));
        assertThat(result, not(queue.toString()));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorThrowsExceptionWhenNextOnEndOfQueue() {
        queue.enqueue("a");

        Iterator<String> iter = queue.iterator();
        iter.next();
        iter.next();

    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorThrowsExceptionWhenNextOnEmptyQueue() {
        Iterator<String> iter = queue.iterator();
        iter.next();
    }
}
