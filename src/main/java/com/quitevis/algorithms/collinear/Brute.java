package com.quitevis.algorithms.collinear;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;

import java.util.Arrays;

public class Brute {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        In in = new In(args[0]);
        int count = in.readInt();
        Point[] points = new Point[count];
        for (int x = 0; x < count; ++x) {
            points[x] = new Point(in.readInt(), in.readInt());
            points[x].draw();
        }

        Arrays.sort(points);

        for (int a = 0; a < points.length; ++a) {
            for (int b = a + 1; b < points.length; ++b) {
                for (int c = b + 1; c < points.length; ++c) {
                    for (int d = c + 1; d < points.length; ++d) {
                        double slope1 = points[a].slopeTo(points[b]);
                        double slope2 = points[a].slopeTo(points[c]);
                        double slope3 = points[a].slopeTo(points[d]);
                        if ((slope1 == slope2) && (slope2 == slope3)) {
                            points[a].drawTo(points[d]);
                            System.out.println(points[a].toString() + " -> "
                                    + points[b].toString() + " -> "
                                    + points[c].toString() + " -> "
                                    + points[d].toString());
                        }
                    }

                }

            }

        }
        // display to screen all at once
        StdDraw.show(0);
    }
}
