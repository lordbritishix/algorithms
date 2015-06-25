package com.quitevis.algorithms.recursivesum;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lordbritishix on 20/05/15.
 */
public class RecursiveSumTest {
    private RecursiveSum fib;

    @Before
    public void beforeEachTests() {
        fib = new RecursiveSum();
    }

    @Test
    public void fibonacaciReturnsCorrectResult() {
        assertThat(fib.fibonacci(5), is(5));

        //Base case tests
        assertThat(fib.fibonacci(1), is(1));
        assertThat(fib.fibonacci(2), is(1));
        assertThat(fib.fibonacci(0), is(0));
    }

    public void recursiveSumReturnsCorrectResult() {
        assertThat(fib.recursiveSum(new int[]{1, 2, 3, 4, 5}, 0), is(15));
        assertThat(fib.recursiveSum(new int[]{10, 9, 8, 1, 2}, 0), is(30));
        assertThat(fib.recursiveSum(new int[]{10, -5, 5}, 0), is(10));
        assertThat(fib.recursiveSum(new int[]{1}, 0), is(1));
        assertThat(fib.recursiveSum(new int[]{}, 0), is(0));
    }
}
