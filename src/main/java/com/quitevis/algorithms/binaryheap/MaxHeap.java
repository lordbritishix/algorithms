package com.quitevis.algorithms.binaryheap;

public class MaxHeap extends BinaryHeap {

    public MaxHeap(int size) {
        super(size);
    }
    
    @Override
    public void swim(int k) {
        int current = k;
        //k/2 is the parent of k
        while (current != 1) {
            //if parent (k/2) is less than child (k), swap parent and child 
            if (getData(current / 2) < getData(current)) {
                int swap = getData(current / 2);
                setData(current / 2, getData(current));
                setData(current, swap);
            }
            
            //point k to the parent and swim this up
            current = current / 2;
        }
    }

    @Override
    public void sink(int k) {
        int current = k;

        //k is parent
        //2*k is left child
        //2*k+1 is right child
        while (2 * current <= getCurrentSize()) {
             int j = 2 * current;
             
             //if right child is greater than left child, 
             //then point j to the right child, otherwise,
             //have it remain at the left child
             if ((j < getCurrentSize()) && (getData(j) < getData(j+1))) {
                 j++;
             }
             
             //if parent is greater than or equal to the selected child, 
             //then terminate the loop - we do not need the swap 
             if (getData(current) >= getData(j)) {
                 break;
             }
             
             //Else, swap the parent with the selected child
             int swap = getData(current);
             setData(current, getData(j));
             setData(j, swap);
             
             //and move the pointer (k) to the selected child and
             //sink it down
            current = j;
        }
    }
}
