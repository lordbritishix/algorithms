package com.quitevis.algorithms.recursivesum;

/**
 * Created by lordbritishix on 20/05/15.
 */
public class RecursiveSum {
    // fib(n) = fib(n-1) + fib(n-2)
    // fib(6) = fib(5) + fib(4)  // 5 + 3 = 8
    // fib(5) = fib(4) + fib(3)  // 3 + 2 = 5
    // fib(4) = fib(3) + fib(2)  // 2 + 1 = 3
    // fib(3) = fib(2) + fib(1)  // 1 + 1 = 2
    // fib(2) = fib(1) + fib(0)  // 1 + 0 = 1
    // fib(1) = 1
    // fib(0) = 0
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // rec(5, 4, 3, 2, 1) = data[n] + rec(data[n+1 .. n])
    public int recursiveSum(int[] data, int index) {
        if (index == data.length - 1) {
            return data[index];
        }

        return data[index] + recursiveSum(data, index + 1);
    }
}
