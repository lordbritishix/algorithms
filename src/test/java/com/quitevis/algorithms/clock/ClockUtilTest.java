package com.quitevis.algorithms.clock;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lordbritishix on 02/06/15.
 */
public class ClockUtilTest {
    private ClockUtil clock;

    @Before
    public void beforeEachTests() {
        clock = new ClockUtil();
    }

    @Test
    public void getAngleReturnsCorrectAngle() {
        //12:00
        assertThat(clock.getAngle(12, 0), is(360));

        //3:00
        assertThat(clock.getAngle(3, 0), is(90));

        //6:00
        assertThat(clock.getAngle(6, 0), is(180));

        //2:30
        assertThat(clock.getAngle(2, 30), is(105));

        //9:00
        assertThat(clock.getAngle(9, 0), is(270));

        //11:00
        assertThat(clock.getAngle(11, 0), is(330));
    }
}
