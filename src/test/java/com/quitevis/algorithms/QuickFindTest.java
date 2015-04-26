package com.quitevis.algorithms;

import com.quitevis.algorithms.unionfind.QuickFind;
import com.quitevis.algorithms.unionfind.UnionFindBase;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class QuickFindTest {
    private UnionFindBase unionFind;

    @Test
    public void testToString1() {
        unionFind = new QuickFind(10);
        assertThat(unionFind.toString(), is("0,1,2,3,4,5,6,7,8,9"));
    }

    @Test
    public void testToString2() {
        unionFind = new QuickFind(0);
        assertThat(unionFind.toString(), is(""));
    }

    @Test
    public void testToString3() {
        unionFind = new QuickFind(1);
        assertThat(unionFind.toString(), is("0"));
    }

    @Test
    public void testUnionFind1() {
        unionFind = new QuickFind(10);
        assertThat(unionFind.toString(), is("0,1,2,3,4,5,6,7,8,9"));

        unionFind.union(4, 3);
        assertThat(unionFind.toString(), is("0,1,2,3,3,5,6,7,8,9"));

        unionFind.union(3, 8);
        assertThat(unionFind.toString(), is("0,1,2,8,8,5,6,7,8,9"));

        unionFind.union(6, 5);
        assertThat(unionFind.toString(), is("0,1,2,8,8,5,5,7,8,9"));

        unionFind.union(9, 4);
        assertThat(unionFind.toString(), is("0,1,2,8,8,5,5,7,8,8"));

        unionFind.union(2, 1);
        assertThat(unionFind.toString(), is("0,1,1,8,8,5,5,7,8,8"));

        unionFind.union(8, 9);
        assertThat(unionFind.toString(), is("0,1,1,8,8,5,5,7,8,8"));

        unionFind.union(5, 0);
        assertThat(unionFind.toString(), is("0,1,1,8,8,0,0,7,8,8"));

        unionFind.union(7, 2);
        assertThat(unionFind.toString(), is("0,1,1,8,8,0,0,1,8,8"));

        unionFind.union(6, 1);
        assertThat(unionFind.toString(), is("1,1,1,8,8,1,1,1,8,8"));

        assertThat(unionFind.isConnected(0, 7), is(true));
        assertThat(unionFind.isConnected(1, 0), is(true));
        assertThat(unionFind.isConnected(1, 9), is(false));
        assertThat(unionFind.isConnected(8, 9), is(true));
        assertThat(unionFind.isConnected(4, 9), is(true));
        assertThat(unionFind.isConnected(9, 5), is(false));
        assertThat(unionFind.isConnected(0, 0), is(true));
    }

    @Test
    public void testUnionFind2() {
        unionFind = new QuickFind(10);
        unionFind.union(2, 8);
        unionFind.union(3, 0);
        unionFind.union(8, 9);
        unionFind.union(0, 6);
        unionFind.union(3, 7);
        unionFind.union(5, 7);

        assertThat(unionFind.toString(), is("7,1,9,7,4,7,7,7,9,9"));
    }
}
