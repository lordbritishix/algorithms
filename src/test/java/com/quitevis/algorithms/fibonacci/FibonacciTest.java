package com.quitevis.algorithms.fibonacci;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lordbritishix on 20/05/15.
 */
public class FibonacciTest {
    private Fibonacci fib;

    @Before
    public void beforeEachTests() {
        fib = new Fibonacci();
    }

    @Test
    public void fibonacaciReturnsCorrectResult() {
        assertThat(fib.fibonacci(5), is(5));

        //Base case tests
        assertThat(fib.fibonacci(1), is(1));
        assertThat(fib.fibonacci(2), is(1));
        assertThat(fib.fibonacci(0), is(0));
    }
}
