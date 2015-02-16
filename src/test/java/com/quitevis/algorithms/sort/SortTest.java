package com.quitevis.algorithms.sort;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortTest {
    private static SortBase sort;
    
    @BeforeClass
    public static void beforeAllTests() {
        sort = new ShellSort();
    }
    
    @Test
    public void testExam() {
        int[] input = new int[] {53, 37, 29, 56, 97, 75, 26, 42, 35, 67};
        sort.sort(input);

    }
    
    @Test
    public void testExam2() {
        int[] input = new int[] {48, 63, 91, 45, 66, 11, 47, 20, 39, 98};
        sort.sort(input);
    }

    
    @Test
    public void testSortWithRandomUnsortedElements() {
        int[] input = new int[] {5, 2, 55, 23, 21, 65, 1, 0};
        sort.sort(input);
        assertThat(Arrays.toString(input), is("[0, 1, 2, 5, 21, 23, 55, 65]"));
    }
    
    @Test
    public void testSortWithOneElement() {
        int[] input = new int[] {0};
        sort.sort(input);
        assertThat(Arrays.toString(input), is("[0]"));
    }

    @Test
    public void testSortWithNoElement() {
        int[] input = new int[] {};
        sort.sort(input);
        assertThat(Arrays.toString(input), is("[]"));
    }

    @Test
    public void testSortWithSortedElements() {
        int[] input = new int[] {1, 2, 3, 4, 5};
        sort.sort(input);
        assertThat(Arrays.toString(input), is("[1, 2, 3, 4, 5]"));
    }

    @Test
    public void testSortWithDescendingElements() {
        int[] input = new int[] {5, 4, 3, 2, 1};
        sort.sort(input);
        assertThat(Arrays.toString(input), is("[1, 2, 3, 4, 5]"));
    }

    @Test
    public void testSortWithPartiallySortedArray() {
        int[] input = new int[] {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        sort.sort(input);
        assertThat(Arrays.toString(input), is("[0, 0, 0, 0, 0, 1, 1, 1, 1, 1]"));
    }

}
