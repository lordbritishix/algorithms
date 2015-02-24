package com.quitevis.algorithms.sort;

public abstract class MergeSortBase implements SortBase {
    /**
     * Merges left subarray (lo - mid) and right subarray (mid+1 - hi)
     * Uses aux storage to facilitate merging:
     * 1. Copy data from lo to hi to aux
     * 2. Perform merge, copying back from aux to data
     */
    protected void merge(int[] data, int[] aux, int lo, int mid, int hi) {
        for (int x = lo; x <= hi; ++x) {
            aux[x] = data[x];
        }

        //left subarray (aux[i])
        int i = lo;
        
        //right subarray (aux[j])
        int j = mid + 1;
        
        for (int x = lo; x <= hi; ++x) {
            //If the left subarray has been already merged, then merge the rest of the right subarray
            if (i > mid) {
                data[x] = aux[j];
                j++;
            }
            //If the right subarray has been already merged, then merge the rest of the left subarray
            else if (j > hi) {
                data[x] = aux[i];
                i++;
            }
            //Merge to data[x] whichever is smaller between between the element on the left (aux[i] or the right [aux[j] subarray
            else if (aux[i] > aux[j]) {
                data[x] = aux[j];
                j++;
            }
            else {
                data[x] = aux[i];
                i++;
            }
        }
    }
}
