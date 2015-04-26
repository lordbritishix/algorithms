package com.quitevis.algorithms.binaryheap;

public class MinHeap extends BinaryHeap {
    public MinHeap(int size) {
        super(size);
    }

    //k is child node
    //k / 2 is parent of the child node
    @Override
    public void swim(int k) {
        int current = k;

        while (current != 1) {
            if (getData(current) < getData(current / 2)) {
                int swap = getData(current);
                setData(current, getData(current / 2));
                setData(current / 2, swap);
                current = current / 2;
            } else {
                break;
            }
        }
    }

    //k is parent node
    //2k is left node
    //2k+1 is right node
    @Override
    public void sink(int k) {
        int current = k;
        int j = 2 * current;
        while (j <= getCurrentSize()) {
            if ((j < getCurrentSize()) && (getData(j) > getData(j + 1))) {
                j++;
            }

            if (getData(current) < getData(j)) {
                break;
            }

            int swap = getData(current);
            setData(current, getData(j));
            setData(j, swap);

            current = j;
            j = 2 * current;
        }
    }

}
