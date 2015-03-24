package com.quitevis.algorithms.binaryheap;

public class MinHeap extends BinaryHeap {
    public MinHeap(int size) {
        super(size);
    }

    //k is child node
    //k / 2 is parent of the child node
    @Override
    public void swim(int k) {
        int parent = k;
        while (parent != 1) {
            if (getData(parent) < getData(parent / 2)) {
                int swap = getData(parent);
                setData(parent, getData(parent / 2));
                setData(parent / 2, swap);
                parent = parent / 2;
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
        int parent = k;
        int j = 2*parent;
        while (j <= getCurrentSize()) {
            if ((j < getCurrentSize()) && (getData(j) > getData(j + 1))) {
                j++;
            }
            
            if (getData(parent) < getData(j)) {
                break;
            }
            
            int swap = getData(parent);
            setData(parent, getData(j));
            setData(j, swap);
            
            parent = j;
            j = 2*parent;
        }
    }

}
