package com.quitevis.algorithms.factorial;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lordbritishix on 20/05/15.
 */
public class FactorialTest {
    private Factorial factorial;

    @Before
    public void beforeEachTests() {
        factorial = new Factorial();
    }

    @Test
    public void factorialReturnsCorrectResult() {
        assertThat(factorial.factorial(5), is(120));
        assertThat(factorial.factorial(0), is(1));
    }
}
