package com.quitevis.algorithms.sort;

import java.util.Arrays;

/**
 * 1. Find the smallest on the sub-array
 * 2. Swap
 * 
 * Performance is (n^2) / 2
 * 
 * @author lordbritishix
 */
public class SelectionSort implements SortBase {
    public void sort(int[] input) {
        for (int x = 0; x < input.length; ++x) {
            int minIdx = x;
            for (int y = x; y < input.length; ++y) {
                //find minimum and then swap
                if (input[y] <= input[minIdx]) {
                    minIdx = y;
                }
            }
            
            int swap = input[x];
            input[x] = input[minIdx];
            input[minIdx] = swap;
            
            System.out.println(Arrays.toString(input));
        }
    }
}
