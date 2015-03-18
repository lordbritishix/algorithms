package com.quitevis.algorithms.percolate;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

//http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
public class Percolation {
    private final int n;
    
    private final boolean[] openGrid;
    private final WeightedQuickUnionUF unionFind;
    private final WeightedQuickUnionUF unionFind2;

    private static final int OFFSET_2 = 2;
    private static final int OFFSET_1 = 1;

    // create N-by-N grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.n = n;
        
        openGrid = new boolean[n * n];
        unionFind = new WeightedQuickUnionUF((n * n) + OFFSET_2);
        unionFind2 = new WeightedQuickUnionUF((n * n) + OFFSET_1);
        
        //Indexes 0 and 1 are used for "virtual sites" so we can quickly
        //check if the system percolates or not
        for (int x = OFFSET_2; x < n + OFFSET_2; ++x) {
            unionFind.union(0, x);
            unionFind.union(1, (n * (n - 1)) + x);
        }
        
        for (int x = 0; x < n + OFFSET_1; ++x) {
            unionFind2.union(0, x);
        }
        
        java.util.Arrays.fill(openGrid, false);
    }
    
    // open site (row i, column j) if it is not open already    
    public void open(int i, int j) {
        validateParams(i, j);
        
        openGrid[getIndexFor(i, j)] = true;
        
        int centerIdx = getIndexFor(i, j);

        int leftIdx = getIndexFor(i, j - 1);
        int rightIdx = getIndexFor(i, j + 1);
        int upIdx = getIndexFor(i - 1, j);
        int downIdx = getIndexFor(i + 1, j);
        
        if ((upIdx != -1) && isOpen(i - 1, j)) {
            unionFind.union(centerIdx + OFFSET_2, upIdx + OFFSET_2);
            unionFind2.union(centerIdx + OFFSET_1, upIdx + OFFSET_1);
        }
        
        if ((downIdx != -1) && isOpen(i + 1, j)) {
            unionFind.union(centerIdx + OFFSET_2, downIdx + OFFSET_2);
            unionFind2.union(centerIdx + OFFSET_1, downIdx + OFFSET_1);
        }
        
        if ((leftIdx != -1) && isOpen(i, j - 1)) {
            unionFind.union(centerIdx + OFFSET_2, leftIdx + OFFSET_2);
            unionFind2.union(centerIdx + OFFSET_1, leftIdx + OFFSET_1);
        }
        
        if ((rightIdx != -1) && isOpen(i, j + 1)) {
            unionFind.union(centerIdx + OFFSET_2, rightIdx + OFFSET_2);
            unionFind2.union(centerIdx + OFFSET_1, rightIdx + OFFSET_1);
        }
    }
    
    // is site (row i, column j) open?    
    public boolean isOpen(int i, int j) {
        validateParams(i, j);
        
        return openGrid[getIndexFor(i, j)];
    }
    
    // is site (row i, column j) full?    
    public boolean isFull(int i, int j) {
        validateParams(i, j);
        
        if (!isOpen(i, j)) {
            return false;
        }
        
        return unionFind2.connected(0, getIndexFor(i, j) + OFFSET_1);
    }
    
    // does the system percolate?    
    public boolean percolates() {
        if ((n == 1) && (!isOpen(1, 1))) {
            return false;
        }
        
        return unionFind.connected(0, 1);
    }
    
    public int getN() {
        return n;
    }

    public boolean isConnected(int i, int j, int k, int l) {
        validateParams(i, j);
        validateParams(k, l);
        
        int x = getIndexFor(i, j) + OFFSET_2;
        int y = getIndexFor(k, l) + OFFSET_2;
        return unionFind.connected(x, y);
    }
    
    private int getIndexFor(int i, int j) {
        try {
            validateParams(i, j);
        }
        catch (IndexOutOfBoundsException e) {
            return -1;
        }
        
        return ((i - 1) * n) + (j - 1);
    }
    
    private void validateParams(int i, int j) {
        if ((i <= 0) || (i > n) || (j <= 0) || (j > n)) {
            throw new IndexOutOfBoundsException();
        }
    }
}
