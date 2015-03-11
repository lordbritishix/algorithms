package com.quitevis.algorithms.collinear;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class PointTest {
    @Test
    public void slopeToComputesForVerticalLine() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        
        assertThat(p1.slopeTo(p2), is(Double.POSITIVE_INFINITY));
    }
    
    @Test
    public void slopeToComputesForHorizontalLine() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        
        assertThat(p1.slopeTo(p2), is(0.0d));
    }

    @Test
    public void slopeToComputesForSamePoint() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        
        assertThat(p1.slopeTo(p2), is(Double.NEGATIVE_INFINITY));
    }

    @Test
    public void slopeToComputesForPositiveSlope() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        
        assertThat(p1.slopeTo(p2), is(1.0d));
    }

    @Test
    public void slopeToComputesForNegativeSlope() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 0);
        
        assertThat(p1.slopeTo(p2), is(-1.0d));
    }
}
