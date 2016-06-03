package com.quitevis.algorithms.knapsack;

import java.util.List;
import com.google.common.collect.Lists;

public final class IntegerKnapsackSolver {
    //CHECKSTYLE:OFF
    public List<Item> solve(List<Item> items, int maxWeight) {
        List<Item> result = Lists.newArrayList();

        int N = items.size();
        int W = maxWeight;

        int[] profit = new int[N + 1];
        int[] weight = new int[N + 1];


        // generate random instance, items 1..N
        for (int n = 1; n <= N; n++) {
            profit[n] = items.get(n - 1).getValue();
            weight[n] = items.get(n - 1).getWeight();
        }

        // opt[n][w] = max profit of packing items 1..n with weight limit w
        // sol[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
        int[][] opt = new int[N + 1][W + 1];
        boolean[][] sol = new boolean[N + 1][W + 1];

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {

                // don't take item n
                int option1 = opt[n - 1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weight[n] <= w) option2 = profit[n] + opt[n - 1][w - weight[n]];

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
            }
        }

        // determine which items to take
        boolean[] take = new boolean[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) {
                result.add(items.get(n - 1));
                take[n] = true;
                w = w - weight[n];
            } else {
                take[n] = false;
            }
        }

        return result;
    }
}
