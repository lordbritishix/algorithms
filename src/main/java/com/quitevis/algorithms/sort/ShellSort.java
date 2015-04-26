package com.quitevis.algorithms.sort;

/**
 * Variant of insertion sort
 * Perfoms h-sort using Knuth's sequence based on 3x + 1
 *
 * @author lordbritishix
 */
public class ShellSort implements SortBase {

    //Using 3x + 1
    public void sort(int[] input) {

        //Find max of h
        int h = 1;
        while (h < input.length) {
            int temp = (3 * h) + 1;

            if (temp > input.length) {
                break;
            }

            h = temp;
        }

        while (h >= 1) {
            for (int x = h; x < input.length; ++x) {
                for (int y = x; y >= h; y -= h) {
                    if (input[y] < input[y - h]) {
                        int swap = input[y];
                        input[y] = input[y - h];
                        input[y - h] = swap;
                    } else {
                        break;
                    }
                }
            }

            h = h / 3;
        }
    }
}
