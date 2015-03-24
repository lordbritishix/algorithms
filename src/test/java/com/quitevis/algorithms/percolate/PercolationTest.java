package com.quitevis.algorithms.percolate;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PercolationTest {
    @Test
    public void allSitesAreClosedOnConstruction() {
        Percolation p = new Percolation(5);

        for (int x = 1; x <= p.getN(); ++x) {
            for (int y = 1; y <= p.getN(); ++y) {
                assertThat(p.isOpen(x, y), is(false));
            }
        }
    }

    @Test
    public void openOpensTheSite() {
        Percolation p = new Percolation(5);
        p.open(3, 3);
        assertThat(p.isOpen(3, 3), is(true));

        p.open(3, 3);
        assertThat(p.isOpen(3, 3), is(true));

        p.open(1, 1);
        assertThat(p.isOpen(1, 1), is(true));

        p.open(5, 5);
        assertThat(p.isOpen(5, 5), is(true));

        assertThat(p.isOpen(2, 5), is(false));
    }

    @Test
    public void openConnectsAdjacentSites1() {
        Percolation p = new Percolation(3);

        p.open(2, 2);
        assertThat(p.isConnected(2, 2, 2, 3), is(false));
        assertThat(p.isConnected(2, 2, 2, 1), is(false));
        assertThat(p.isConnected(2, 2, 1, 2), is(false));
        assertThat(p.isConnected(2, 2, 3, 2), is(false));

        p.open(2, 3);
        assertThat(p.isConnected(2, 2, 2, 3), is(true));
        assertThat(p.isConnected(2, 2, 2, 1), is(false));
        assertThat(p.isConnected(2, 2, 1, 2), is(false));
        assertThat(p.isConnected(2, 2, 3, 2), is(false));

        p.open(2, 1);
        assertThat(p.isConnected(2, 2, 2, 3), is(true));
        assertThat(p.isConnected(2, 2, 2, 1), is(true));
        assertThat(p.isConnected(2, 2, 1, 2), is(false));
        assertThat(p.isConnected(2, 2, 3, 2), is(false));

        p.open(1, 2);
        assertThat(p.isConnected(2, 2, 2, 3), is(true));
        assertThat(p.isConnected(2, 2, 2, 1), is(true));
        assertThat(p.isConnected(2, 2, 1, 2), is(true));
        assertThat(p.isConnected(2, 2, 3, 2), is(false));

        p.open(3, 2);
        assertThat(p.isConnected(2, 2, 2, 3), is(true));
        assertThat(p.isConnected(2, 2, 2, 1), is(true));
        assertThat(p.isConnected(2, 2, 1, 2), is(true));
        assertThat(p.isConnected(2, 2, 3, 2), is(true));
    }

    @Test
    public void openConnectsAdjacentSites2() {
        Percolation p = new Percolation(3);

        p.open(1, 1);
        p.open(1, 2);
        p.open(1, 3);

        assertThat(p.isConnected(1, 1, 1, 3), is(true));
        assertThat(p.isConnected(1, 2, 3, 2), is(false));

        p.open(3, 1);
        p.open(3, 2);
        p.open(3, 3);
        assertThat(p.isConnected(3, 1, 3, 3), is(true));
    }

    @Test
    public void openConnectsAdjacentSites3() {
        Percolation p = new Percolation(3);

        for (int x = 1; x <= 3; ++x) {
            for (int y = 1; y <= 3; ++y) {
                p.open(x, y);
            }
        }

        assertThat(p.isConnected(1, 1, 3, 3), is(true));
        assertThat(p.isConnected(3, 1, 1, 3), is(true));
    }

    @Test
    public void percolatesTest1() {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        assertThat(p.percolates(), is(false));

        p.open(2, 1);
        assertThat(p.percolates(), is(false));

        p.open(3, 1);
        assertThat(p.percolates(), is(true));
    }

    @Test
    public void percolatesTest2() {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        assertThat(p.percolates(), is(false));

        p.open(2, 2);
        assertThat(p.percolates(), is(false));

        p.open(3, 3);
        assertThat(p.percolates(), is(false));
    }

    @Test
    public void percolatesTest3() {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        assertThat(p.percolates(), is(false));

        p.open(2, 1);
        assertThat(p.percolates(), is(false));

        p.open(2, 2);
        assertThat(p.percolates(), is(false));

        p.open(3, 2);
        assertThat(p.percolates(), is(true));
    }

    @Test
    public void percolatesTest4() {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        assertThat(p.percolates(), is(false));

        p.open(1, 2);
        assertThat(p.percolates(), is(false));

        p.open(1, 3);
        assertThat(p.percolates(), is(false));

        p.open(2, 1);
        assertThat(p.percolates(), is(false));

        p.open(2, 2);
        assertThat(p.percolates(), is(false));

        p.open(2, 3);
        assertThat(p.percolates(), is(false));

        p.open(3, 3);
        assertThat(p.percolates(), is(true));
    }

    @Test
    public void percolatesTest5() {
        Percolation p = new Percolation(1);
        assertThat(p.percolates(), is(false));
    }

    @Test
    public void isFull1() {
        Percolation p = new Percolation(3);
        assertThat(p.isFull(1, 1), is(false));
        assertThat(p.isFull(1, 2), is(false));
        assertThat(p.isFull(1, 3), is(false));

        p.open(1, 1);
        assertThat(p.isFull(1, 1), is(true));
        assertThat(p.isFull(1, 2), is(false));
        assertThat(p.isFull(1, 3), is(false));

        p.open(1, 2);
        assertThat(p.isFull(1, 1), is(true));
        assertThat(p.isFull(1, 2), is(true));
        assertThat(p.isFull(1, 3), is(false));

        p.open(1, 3);
        assertThat(p.isFull(1, 1), is(true));
        assertThat(p.isFull(1, 2), is(true));
        assertThat(p.isFull(1, 3), is(true));

        assertThat(p.isFull(2, 1), is(false));
        assertThat(p.isFull(2, 2), is(false));
    }

    @Test
    public void isFull2() {
        Percolation p = new Percolation(3);
        p.open(3, 1);
        assertThat(p.isFull(1, 1), is(false));
        assertThat(p.isFull(2, 1), is(false));
        assertThat(p.isFull(3, 1), is(false));

        p.open(1, 1);
        assertThat(p.isFull(1, 1), is(true));
        assertThat(p.isFull(2, 1), is(false));
        assertThat(p.isFull(3, 1), is(false));

        p.open(2, 1);
        assertThat(p.isFull(1, 1), is(true));
        assertThat(p.isFull(2, 1), is(true));
        assertThat(p.isFull(3, 1), is(true));
    }

    @Test
    public void isFull3() {
        Percolation p = new Percolation(6);
        p.open(1, 6);

        assertThat(p.isFull(1, 6), is(true));
    }


    @Test(expected = IllegalArgumentException.class)
    public void constructionWithInvalidNThrowsException() {
        new Percolation(0);
    }
}
