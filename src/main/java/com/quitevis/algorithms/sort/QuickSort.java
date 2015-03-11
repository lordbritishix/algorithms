package com.quitevis.algorithms.sort;

import java.util.Arrays;

import org.slf4j.Logger;

public class QuickSort implements SortBase {
    private Logger log = org.slf4j.LoggerFactory.getLogger(QuickSort.class);

    //1. Pick partition
    //2. Move items less than partition to left
    //3. Move items greater than partition to right
    public void sort(int[] input) {
        sort(input, 0, input.length - 1);
    }

    private void sort(int[] input, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        
        int partition = partition(input, lo, hi);
        
        sort(input, lo, partition - 1);
        sort(input, partition + 1, hi);
    }
    
    public int partition(int[] data, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        
        while (true) {
            while (data[++i] < data[lo]) {
                if (i == hi) {
                    break;
                }
            }
            
            while (data[--j] > data[lo]) {
                if (j == lo) {
                    break;
                }
            }
            
            if (i >= j) {
                break;
            }
            
            int swap = data[i];
            data[i] = data[j];
            data[j] = swap;
        }
        
        int swap = data[lo];
        data[lo] = data[j];
        data[j] = swap;
        

        log.trace("Pivot: {}, Data: {}", j, Arrays.toString(data));
        return j;
    }
    
}
