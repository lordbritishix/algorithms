package com.quitevis.algorithms.queue;

import edu.princeton.cs.introcs.StdIn;

import java.util.Iterator;

public class Subset {
    public static void main(String[] args) {
        int count = Integer.valueOf(args[0]);

        RandomizedQueue<String> rand = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            rand.enqueue(StdIn.readString());
        }

        int ctr = 0;
        Iterator<String> iter = rand.iterator();

        while ((iter.hasNext()) && (ctr < count)) {
            System.out.println(iter.next());
            ctr++;
        }
    }
}
