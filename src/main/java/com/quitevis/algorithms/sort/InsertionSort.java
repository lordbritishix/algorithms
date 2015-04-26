package com.quitevis.algorithms.sort;


/**
 * Insert to proper position until i <= i + 1
 * <p/>
 * Performance is (n^2) / 4 for randomly sorted arrays
 * Best case is n for sorted arrays
 * Worst case is (n^2) / 2 if array is in descending order
 *
 * @author lordbritishix
 */
public class InsertionSort implements SortBase {
    public void sort(int[] input) {
        for (int x = 0; x < input.length; ++x) {
            for (int y = x; y > 0; --y) {
                if (input[y] < input[y - 1]) {
                    int swap = input[y];
                    input[y] = input[y - 1];
                    input[y - 1] = swap;
                } else {
                    break;
                }
            }
        }
    }
}
