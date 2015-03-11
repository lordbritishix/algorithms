package com.quitevis.algorithms.quickselect;

import org.junit.Test;

public class QuickSelectTest {
    @Test
    public void test() {
        QuickSelect s = new QuickSelect();
        int[] input = new int[]{5, 2, 1, 3, 6};
        System.out.println(s.quickSelect(1, input));
    }
}
