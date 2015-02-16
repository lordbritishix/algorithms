package com.quitevis.algorithms;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.quitevis.algorithms.unionfind.QuickUnion;

public class QuickUnionTest {
    private QuickUnion unionFind;

    @Test
    public void testUnionFind1() {
        unionFind = new QuickUnion(10);
        assertThat(unionFind.toString(), is("0,1,2,3,4,5,6,7,8,9"));

        unionFind.union(4, 3);
        assertThat(unionFind.toString(), is("0,1,2,4,4,5,6,7,8,9"));

        unionFind.union(3, 8);
        assertThat(unionFind.toString(), is("0,1,2,4,4,5,6,7,4,9"));

        unionFind.union(6, 5);
        assertThat(unionFind.toString(), is("0,1,2,4,4,6,6,7,4,9"));

        unionFind.union(9, 4);
        assertThat(unionFind.toString(), is("0,1,2,4,4,6,6,7,4,4"));

        unionFind.union(2, 1);
        assertThat(unionFind.toString(), is("0,2,2,4,4,6,6,7,4,4"));

        unionFind.union(8, 9);
        assertThat(unionFind.toString(), is("0,2,2,4,4,6,6,7,4,4"));

        unionFind.union(5, 0);
        assertThat(unionFind.toString(), is("6,2,2,4,4,6,6,7,4,4"));

        unionFind.union(7, 2);
        assertThat(unionFind.toString(), is("6,2,2,4,4,6,6,2,4,4"));

        unionFind.union(6, 1);
        assertThat(unionFind.toString(), is("6,2,6,4,4,6,6,2,4,4"));

        assertThat(unionFind.isConnected(0, 7), is(true));
        assertThat(unionFind.isConnected(1, 0), is(true));
        assertThat(unionFind.isConnected(1, 9), is(false));
        assertThat(unionFind.isConnected(8, 9), is(true));
        assertThat(unionFind.isConnected(4, 9), is(true));
        assertThat(unionFind.isConnected(9, 5), is(false));
        assertThat(unionFind.isConnected(0, 0), is(true));

        unionFind.union(7, 3);
        assertThat(unionFind.toString(), is("6,2,6,4,6,6,6,2,4,4"));

        assertThat(unionFind.isConnected(0, 7), is(true));
        assertThat(unionFind.isConnected(1, 0), is(true));
        assertThat(unionFind.isConnected(1, 9), is(true));
        assertThat(unionFind.isConnected(8, 9), is(true));
        assertThat(unionFind.isConnected(4, 9), is(true));
        assertThat(unionFind.isConnected(9, 5), is(true));
        assertThat(unionFind.isConnected(0, 0), is(true));
    }

    @Test
    public void testUnionFind2() {
        unionFind = new QuickUnion(10);
        unionFind.union(3, 6);
        unionFind.union(8, 4);
        unionFind.union(2, 7);
        unionFind.union(7, 9);
        unionFind.union(5, 1);
        unionFind.union(6, 5);
        unionFind.union(7, 4);
        unionFind.union(3, 7);
        unionFind.union(7, 0);

        assertThat(unionFind.toString(), is("2,5,2,2,8,3,3,2,2,2"));
    }
}
