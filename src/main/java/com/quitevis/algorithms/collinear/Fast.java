package com.quitevis.algorithms.collinear;

import java.util.Arrays;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;

public class Fast {
    private static void printLineSegment(int start, int offset, 
                                            Point origin, Point[] points) {
        if (origin.compareTo(points[start]) >= 0) {
            return;
        }
        
        System.out.print(origin);
        System.out.print(" -> ");
        
        for (int x = start; x <= start + offset; ++x) {
            System.out.print(points[x]);
            if (x < (start + offset)) {
                System.out.print(" -> ");
            }
        }
        
        System.out.println();
        
        origin.drawTo(points[start + offset]);
    }
    
    public static void main(String[] args) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        In in = new In(args[0]);
        int count = in.readInt();
        Point[] points = new Point[count];
        
        for (int x = 0; x < count; ++x) {
            points[x] = new Point(in.readInt(), in.readInt());
        }
        
        Arrays.sort(points);

        for (int x = 0; x < count; ++x) {
            points[x].draw();
        }

        
        // Get slope between origin and every other points
        // Sort them by SLOPE_ORDER
        for (int x = 0; x < points.length; ++x) {
            Point origin = points[x];
            
            //Work subarray
            Point[] work = new Point[points.length - 1];
            int ctr = 0;
            for (int y = 0; y < points.length; ++y) {
                if (points[y] != origin) {
                    work[ctr++] = points[y];
                }
            }
            
            Arrays.sort(work, origin.SLOPE_ORDER);
            
            int start = 0;
            int offset = 0;
            double previous = 0.0d;
            double current = 0.0d;
            boolean isSet = false;
            for (int y = 0; y < work.length; ++y) {
                current = origin.slopeTo(work[y]);

                if (isSet && (current != previous)) {
                    if ((offset) >= 2) {
                        printLineSegment(start, offset, origin, work);
                    }
                    
                    start = y;
                    offset = 0;
                }
                else {
                    if (isSet) {
                        offset++;
                    }
                }
                
                isSet = true;
                previous = current;
            }        
            
            
            if ((offset) >= 2) {
                printLineSegment(start, offset, origin, work);
            }
        }
    }
    
    
}
