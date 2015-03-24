package com.quitevis.algorithms.sort;

import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortTest {
    private static List<SortBase> sorters = Lists.newArrayList();

    @BeforeClass
    public static void beforeAllTests() {
        sorters.add(new InsertionSort());
        sorters.add(new SelectionSort());
        sorters.add(new ShellSort());
        sorters.add(new MergeSort());
        sorters.add(new BottomUpMergeSort());
        sorters.add(new QuickSort());
    }

    @Test
    public void test() {
        QuickSort s = new QuickSort();
        int[] input = new int[]{0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1};
        s.sort(input);
    }

    @Test
    public void testSortWithRandomUnsortedElements() {
        for (SortBase sort : sorters) {
            int[] input = new int[]{5, 2, 55, 23, 21, 65, 1, 0};
            sort.sort(input);
            assertThat(Arrays.toString(input), is("[0, 1, 2, 5, 21, 23, 55, 65]"));
        }
    }

    @Test
    public void testSortWithOneElement() {
        for (SortBase sort : sorters) {
            int[] input = new int[]{0};
            sort.sort(input);
            assertThat(Arrays.toString(input), is("[0]"));
        }
    }

    @Test
    public void testSortWithNoElement() {
        for (SortBase sort : sorters) {
            int[] input = new int[]{};
            sort.sort(input);
            assertThat(Arrays.toString(input), is("[]"));
        }
    }

    @Test
    public void testSortWithSortedElements() {
        for (SortBase sort : sorters) {
            int[] input = new int[]{1, 2, 3, 4, 5};
            sort.sort(input);
            assertThat(Arrays.toString(input), is("[1, 2, 3, 4, 5]"));
        }
    }

    @Test
    public void testSortWithDescendingElements() {
        for (SortBase sort : sorters) {
            int[] input = new int[]{5, 4, 3, 2, 1};
            sort.sort(input);
            assertThat(Arrays.toString(input), is("[1, 2, 3, 4, 5]"));
        }
    }

    @Test
    public void testSortWithPartiallySortedArray() {
        for (SortBase sort : sorters) {
            int[] input = new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
            sort.sort(input);
            assertThat(Arrays.toString(input), is("[0, 0, 0, 0, 0, 1, 1, 1, 1, 1]"));
        }
    }
}
