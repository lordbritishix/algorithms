package com.quitevis.algorithms.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Double-ended queue using a Doubly-linked list as backend to 
 * achieve O(c) performance for operations that add and remove elements 
 * at the beginning and end of the queue 
 * 
 * @author lordbritishix
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
    private class Node<NodeItem> {
        private NodeItem item;
        private Node<NodeItem> next;
        private Node<NodeItem> previous;
        
        public Node(NodeItem item) {
            this.item = item;
        }
        
        public void setNext(Node<NodeItem> that) {
            this.next = that;
        }
        
        public void setPrevious(Node<NodeItem> that) {
            this.previous = that;
        }
        
        public NodeItem getItem() {
            return item;
        }
        
        public Node<NodeItem> getNext() {
            return next;
        }
        
        public Node<NodeItem> getPrevious() {
            return previous;
        }
    }
    
    private class DoubleEndedQueueIterator implements Iterator<Item> {
        private Node<Item> iter = first;
        
        public boolean hasNext() {
            return iter != null;
        }

        public Item next() {
            if (iter == null) {
                throw new NoSuchElementException();
            }
            
            Item ret = iter.getItem();
            iter = iter.getNext();
            
            return ret;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private Node<Item> first;
    private Node<Item> last;
    private int count = 0;

    // construct an empty deque
    public Deque() {
        
    }
    
    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque    
    public int size() {
        return count;
    }
    
    // add the item to the front    
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        
        if (first == null) {
            first = new Node<Item>(item);
            last = first;
        }
        else {
            Node<Item> newNode = new Node<Item>(item);
            newNode.setNext(first);
            first.setPrevious(newNode);
            first = newNode;
        }
        
        count++;
    }
    
    // add the item to the end    
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        if (last == null) {
            last = new Node<Item>(item);
            first = last;
        }
        else {
            Node<Item> newNode = new Node<Item>(item);
            newNode.setPrevious(last);
            last.setNext(newNode);
            last = newNode;
        }
        
        count++;
    }
    
    // remove and return the item from the front    
    public Item removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        
        Item current = first.getItem();
        first = first.getNext();
        
        if (first != null) {
            first.getPrevious().setNext(null);
            first.setPrevious(null);
        }
        else {
            last = null;
        }
        
        count--;
        
        return current;
    }
    
    // remove and return the item from the end    
    public Item removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        
        Item current = last.getItem();
        last = last.getPrevious();
        
        if (last != null) {
            last.getNext().setPrevious(null);
            last.setNext(null);
        } 
        else {
            first = null;
        }
        
        count--;
        
        return current;
    }
    
    // return an iterator over items in order from front to end    
    public Iterator<Item> iterator() {
        return new DoubleEndedQueueIterator();
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
