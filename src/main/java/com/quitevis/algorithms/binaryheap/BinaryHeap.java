package com.quitevis.algorithms.binaryheap;

import java.util.NoSuchElementException;

public abstract class BinaryHeap {
    //Binary tree, represented as an array
    private Integer[] data;
    private int ctr = 0;
    
    public int getData(int index) {
        return data[index];
    }
   
    public void setData(int index, int value) {
        data[index] = value;
    }
    
    public int getSize() {
        return data.length;
    }
    
    public BinaryHeap(int size) {
        //Starts at index 1 to simplify index arithmetic
        data = new Integer[size + 1];
    }
    
    public void insert(int value) {
        if ((ctr + 1) > data.length - 1) {
            throw new ArrayIndexOutOfBoundsException(ctr + 1);
        }
        
        data[++ctr] = value;
        
        swim(ctr);
    }
    
    public int pop() throws NoSuchElementException {
        if (ctr <= 0) {
            throw new NoSuchElementException();
        }
        
        int rootValue = data[1];

        data[1] = data[ctr];
        data[ctr] = null;
        ctr--;
        
        sink(1);
        
        return rootValue;
    }
    
    public int peek() {
        if (ctr <= 0) {
            throw new NoSuchElementException();
        }

        return data[1];
    }
    
    public int getMaxSize() {
        return data.length - 1;
    }
    
    public int getCurrentSize() {
        return ctr;
    }
    
    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer("\n");
        int row = 1;
        int rowCtr = 0;
        for (int x = 1; x < ctr; ++x) {
            ret.append(data[x]);
            ret.append(",");
            
            rowCtr++;
            
            if (rowCtr == row) {
                rowCtr = 0;
                row *= 2;
                ret.append("\n");
            }
        }
        
        return ret.toString();
    }
    
    /**
     * k's parent is n/2
     * @param k
     */
    public abstract void swim(int k);

    public abstract void sink(int k);
}
