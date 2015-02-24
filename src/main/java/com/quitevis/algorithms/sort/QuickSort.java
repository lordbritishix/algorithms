package com.quitevis.algorithms.sort;

import java.util.Arrays;

import org.slf4j.Logger;

public class QuickSort implements SortBase {
    Logger log = org.slf4j.LoggerFactory.getLogger(QuickSort.class);

    //1. Pick partition
    //2. Move items less than partition to left
    //3. Move items greater than partition to right
    public void sort(int[] input) {
    }

    public int partition(int[] data, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        
        while (true) {
            while ((i != hi) && (data[i] < data[lo])) {
                i++;
            }
            
            while ((j != lo) && (data[j] > data[lo])) {
                j--;
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
