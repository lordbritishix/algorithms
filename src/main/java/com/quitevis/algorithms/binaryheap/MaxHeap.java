package com.quitevis.algorithms.binaryheap;

public class MaxHeap extends BinaryHeap {

    public MaxHeap(int size) {
        super(size);
    }
    
    @Override
    public void swim(int k) {
        while ((k != 1) && (k / 2) != 0) {
            if (getData(k / 2) < getData(k)) {
                int swap = getData(k / 2);
                setData(k / 2, getData(k));
                setData(k, swap);
            }
            
            k = k / 2;
        }
    }

    @Override
    public void sink(int k) {
        int current = k;
        int next = 2 * current + 1;
        
        if (getCurrentSize() == 1) {
            setData(1, getData(getCurrentSize()));
            return;
        }

        if (getCurrentSize() == 2) {
            if (getData(1) < getData(2)) {
                int swap = getData(1);
                setData(1, getData(2));
                setData(2, swap); 
                current = next;
            }
            
            return;
        }

        
        do {
            if ((getData(current) >= getData(next)) && (getData(current) >= getData(next - 1))) {
                break;
            }
            
            if (getData(next) > getData(next - 1)) {
                int swap = getData(next);
                setData(next, getData(current));
                setData(current, swap); 
                current = next;
            }
            else {
                int swap = getData(next - 1);
                setData(next - 1, getData(current));
                setData(current, swap); 
                current = next - 1;
            }
            
            next = 2 * current + 1; 
        } while (next < getCurrentSize());
    }
}
