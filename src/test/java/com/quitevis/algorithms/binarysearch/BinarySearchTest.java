package com.quitevis.algorithms.binarysearch;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lordbritishix on 13/05/15.
 */
public class BinarySearchTest {
    private BinarySearch bs;

    @Before
    public void beforeEachTests() {
        bs = new BinarySearch();
    }

    @Test
    public void searchReturnsCorrectIndex() {
        assertThat(bs.search(new int[]{1, 2, 3, 4}, 4), is(3));
        assertThat(bs.search(new int[]{1, 2, 3, 4}, 1), is(0));
        assertThat(bs.search(new int[]{1, 2, 3, 4}, 2), is(1));
        assertThat(bs.search(new int[]{1}, 1), is(0));
        assertThat(bs.search(new int[]{1}, 5), is(-1));
    }

    @Test
    public void getMinReturnsCorrectValue() {
        assertThat(bs.getMinFromRotatedSortedArray(new int[]{5, 6, 7, 8, 9, 1}), is(1));
        assertThat(bs.getMinFromRotatedSortedArray(new int[]{5, 4}), is(4));
        assertThat(bs.getMinFromRotatedSortedArray(new int[]{5, 6, 7, 2, 3, 4}), is(2));
        assertThat(bs.getMinFromRotatedSortedArray(new int[]{1, 2, 3, 4}), is(1));
        assertThat(bs.getMinFromRotatedSortedArray(new int[]{1}), is(1));
        assertThat(bs.getMinFromRotatedSortedArray(new int[]{5, 1, 4, 5, 6, 7}), is(1));

    }

}
