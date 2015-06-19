package com.quitevis.algorithms.cycle;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lordbritishix on 18/06/15.
 */
public class CycleTest {
    private Cycle cycle;

    @Before
    public void beforeEachTests() {
        cycle = new Cycle();
    }

    @Test
    public void cycleLengthReturnsCorrectLength() {
        //1, 3, 1, 3, ...
        assertThat(cycle.findLoopLength(new int[]{2, 3, 1, 1, 3}), is(2));

        //1, 2, 3, 4, 5, 0, ...
        assertThat(cycle.findLoopLength(new int[]{1, 2, 3, 4, 5, 0}), is(6));

        //0, ...
        assertThat(cycle.findLoopLength(new int[]{0}), is(0));

        //2, 4, 1, 3, 0, ...
        assertThat(cycle.findLoopLength(new int[]{2, 3, 4, 0, 1, 2, 3}), is(5));

        //1, ...
        assertThat(cycle.findLoopLength(new int[]{1, 1, 1, 1, 1}), is(1));

        assertThat(cycle.findLoopLength(new int[]{}), is(0));
    }


}
