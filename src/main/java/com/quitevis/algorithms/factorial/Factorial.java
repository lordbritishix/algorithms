package com.quitevis.algorithms.factorial;

/**
 * Created by lordbritishix on 20/05/15.
 */
public class Factorial {
    //f(5) = 5 * f(4)
    //f(4) = 4 * f(3)
    //f(3) = 3 * f(2)
    //f(2) = 2 * f(1)
    //f(1) = 1 * f(0)
    //f(0) = 1 -> base case
    public int factorial(int n) {
        if (n <= 0) {
            return 1;
        }

        return  n * factorial(n - 1);
    }
}
