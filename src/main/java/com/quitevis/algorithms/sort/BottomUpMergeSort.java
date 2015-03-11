package com.quitevis.algorithms.sort;

import org.slf4j.Logger;

/**
 * Non-recursive implementation of merge sort
 * 
 * Maximum of log(n) passes to the array 
 * 
 * @author lordbritishix
 *
 */
public class BottomUpMergeSort extends MergeSortBase {
    private Logger log = 
            org.slf4j.LoggerFactory.getLogger(BottomUpMergeSort.class);

    public void sort(int[] input) {
        int[] aux = new int[input.length];
        for (int size = 1; size < input.length; size *= 2) {
            for (int lo = 0; lo < input.length; lo += (size * 2)) {
                int hi = Math.min((lo + (size * 2)) - 1, input.length - 1);
                
                //Handles edge case where size of remaining left subarray is greater 
                //than size of right subarray
                //When this happens, mid is size of the left subarray
                int mid = lo + size - 1;
                
                log.trace("x: {}  -->  lo: {}, mid: {}, hi: {}", size, lo, mid, hi);
                
                merge(input, aux, lo, mid, hi);
            }
        }
    }

}
