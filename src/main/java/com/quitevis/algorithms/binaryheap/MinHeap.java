package com.quitevis.algorithms.binaryheap;

public class MinHeap extends BinaryHeap {
    public MinHeap(int size) {
        super(size);
    }

    //k is child node
    //k / 2 is parent of the child node
    @Override
    public void swim(int k) {
        while (k != 1) {
            if (getData(k) < getData(k / 2)) {
                int swap = getData(k);
                setData(k, getData(k / 2));
                setData(k / 2, swap);
                k = k / 2;
            }
            else {
                break;
            }
        }
    }

    //k is parent node
    //2k is left node
    //2k+1 is right node
    @Override
    public void sink(int k) {
        int j = 2*k;
        while (j <= getCurrentSize()) {
            if ((j < getCurrentSize()) && (getData(j) > getData(j + 1))) {
                j++;
            }
            
            if (getData(k) < getData(j)) {
                break;
            }
            
            int swap = getData(k);
            setData(k, getData(j));
            setData(j, swap);
            
            k = j;
            j = 2*k;
        }
    }

}
