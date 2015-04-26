package com.quitevis.algorithms.percolate;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;


public class PercolationStats {
    private double mean = 0.0d;
    private double stddev = 0.0d;
    private double confidenceLo = 0.0d;
    private double confidenceHi = 0.0d;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int n, int t) {
        if ((n <= 0) || (t <= 0)) {
            throw new IllegalArgumentException();
        }

        double[] experimentData = new double[t];

        for (int x = 0; x < t; ++x) {
            int opened = 0;
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int i = 1 + StdRandom.uniform(n);
                int j = 1 + StdRandom.uniform(n);

                if (!perc.isOpen(i, j)) {
                    opened++;
                }

                perc.open(i, j);
            }
            experimentData[x] = (double) opened / (n * n);
        }

        mean = StdStats.mean(experimentData);
        stddev = StdStats.stddev(experimentData);

        confidenceLo = mean - ((1.96 * stddev) / Math.sqrt(t));
        confidenceHi = mean + ((1.96 * stddev) / Math.sqrt(t));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats p = new PercolationStats(n, t);
        StdOut.println("mean = " + p.mean());
        StdOut.println("stddev = " + p.stddev());
        StdOut.println("95% confidence interval = "
                + "" + p.confidenceLo() + ", " + p.confidenceHi());
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }
}
