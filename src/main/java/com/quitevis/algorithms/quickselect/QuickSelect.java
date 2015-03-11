package com.quitevis.algorithms.quickselect;

import java.util.Arrays;

import org.slf4j.Logger;

public class QuickSelect {
    private Logger log = org.slf4j.LoggerFactory.getLogger(QuickSelect.class);

    public int quickSelect(int nth, int[] input) {
        int lo = 0; 
        int hi = input.length - 1;
        
        while (hi > lo) {
            int partition = partition(input, lo, hi);
            
            if (nth > partition) {
                lo = partition + 1;
            }
            else if (nth < partition) {
                hi = partition - 1;
            }
            else {
                log.trace("Found: {}: {}",  Arrays.toString(input), nth);
                return input[nth];
            }
        }
        
        log.trace("Found: {}: {}",  Arrays.toString(input), nth);
        return input[nth];
    }
    
    
    public int partition(int[] input, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        
        while (true) {
            while (input[++i] < input[lo]) {
                if (i == hi) {
                    break;
                }
            }
            
            while (input[--j] > input[lo]) {
                if (j == lo) {
                    break;
                }
            }
            
            if (i >= j) {
                break;
            }
            
            int swap = input[i];
            input[i] = input[j];
            input[j] = swap;
        }

        int swap = input[lo];
        input[lo] = input[j];
        input[j] = swap;
        
        log.trace("Pivot: {}, Data: {}", j, Arrays.toString(input));

        return j;
    }
}
