package com.quitevis.algorithms.collinear;

import java.util.Comparator;

import edu.princeton.cs.introcs.StdDraw;

public class Point implements Comparable<Point> {
    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        public int compare(Point o1, Point o2) {
            double slopeP1 = slopeTo(o1);  
            double slopeP2 = slopeTo(o2);  
            if (slopeP1 == slopeP2) {
                return 0;  
            }
            
            if (slopeP1 < slopeP2) {
                return -1;  
            }
            else {
                return 1;  
            }
        }
    };       

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
    
    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        int dx = that.x - this.x;  
        int dy = that.y - this.y;  
        
        //0 / 0
        if (dx == 0 && dy == 0) {
            return Double.NEGATIVE_INFINITY;  
        }
        
        //dy / 0
        if (dx == 0) {
            return Double.POSITIVE_INFINITY;  
        }
        
        //0 / dx
        if (dy == 0) {
            return 0;  
        }
        else {
        //dy / dx
            return (double) dy / (double) dx;  
        }
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y < that.y) {
            return -1;  
        }
        
        if (this.y == that.y && this.x < that.x) {
            return -1;  
        }
        
        if (this.y == that.y && this.x == that.x) {
            return 0;  
        }
        else {
            return 1;  
        }
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }

}
