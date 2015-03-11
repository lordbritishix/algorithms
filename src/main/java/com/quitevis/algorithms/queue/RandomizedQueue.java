package com.quitevis.algorithms.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdRandom;

/**
 * Randomized Queue using a resizing array as backend
 * 
 * Array size doubles if limit is reached
 * Array size is halved if number of items are quarter of the array 
 * to avoid thrashing
 * 
 * @author lordbritishix
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private class RandomizedQueueIterator<Data> implements Iterator<Data> {
        private Data[] data;
        private int ptr = 0;
        public RandomizedQueueIterator() {
            data = (Data[]) new Object[n];
            for (int x = 0; x < n; ++x) {
                data[x] = (Data) backend[x];
            }
        }
        
        public boolean hasNext() {
            return ptr != data.length;
        }

        public Data next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            
            int rand = StdRandom.uniform(ptr, data.length);
            Data swap = data[ptr];
            data[ptr] = data[rand];
            data[rand] = swap;
            
            Data ret = data[ptr];
            data[ptr] = null;
            
            ptr++;
            
            return ret;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private Item[] backend; 
    private int n;
    
    public RandomizedQueue() {
        backend = (Item[]) new Object[2];
    }
    
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = backend[i];
        }
        backend = temp;
    }
    
    // is the queue empty?
    public boolean isEmpty() {
        return n == 0;
    }
    
    // return the number of items on the queue    
    public int size() {
        return n;
    }
    
    // add the item    
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        
        if (n == backend.length) { 
            resize(2 * backend.length); 
        }
        
        backend[n] = item;
        n++;
    }
    
    // remove and return a random item    
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        //Pick random element, swap with end of the array
        int idx = StdRandom.uniform(n);

        Item swap = backend[idx];
        backend[idx] = backend[n - 1];
        backend[n - 1] = swap;
        
        if ((n > 0) && (n == backend.length/4)) {
            resize(backend.length/2);
        }

        Item ret = backend[n - 1];
        backend[n - 1] = null;
        n--;
        
        return ret;
    }
    
    // return (but do not remove) a random item    
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return backend[StdRandom.uniform(n)];
    }
    
    // return an independent iterator over items in random order    
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<Item>();
    }
    
    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();
        
        for (Item item : this) {
            ret.append(item.toString());
            ret.append(",");
        }

        if (ret.length() > 1) {
            return ret.substring(0, ret.length() - 1);
        }
        else {
            return ret.toString();
        }
    }
}
