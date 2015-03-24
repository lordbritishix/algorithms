package com.quitevis.algorithms.sort;

import org.slf4j.Logger;

import java.util.Arrays;

/**
 * Merge sort implementation
 * <p/>
 * 1. Divide and conquer using recursion
 * 2. n log n performance
 * 3. 2n memory requirement (including input)
 *
 * @author lordbritishix
 */
public class MergeSort extends MergeSortBase {
    private Logger log = org.slf4j.LoggerFactory.getLogger(MergeSort.class);

    public void sort(int[] input) {
        int[] aux = new int[input.length];

        sort(input, aux, 0, input.length - 1);
    }

    //First half: lo to mid
    //2nd half: mid + 1 to hi
    private void sort(int[] data, int[] aux, int lo, int hi) {
        //Base case
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        log.trace("#left  --> lo: {}       mid: {}", lo, mid);

        //recurse first half of the subarray
        sort(data, aux, lo, mid);

        log.trace("#right --> lo: {}       mid: {}", mid + 1, hi);

        //recurse second half of the subarray
        sort(data, aux, mid + 1, hi);

        //merge first and second half
        merge(data, aux, lo, mid, hi);

        log.trace(Arrays.toString(data));
    }

}
