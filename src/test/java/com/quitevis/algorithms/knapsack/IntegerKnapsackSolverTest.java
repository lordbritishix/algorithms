package com.quitevis.algorithms.knapsack;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class IntegerKnapsackSolverTest {
    private IntegerKnapsackSolver knapsackSolver;

    private List<Item> input;
    private List<Item> expected;
    private int maxWeight;

    public IntegerKnapsackSolverTest(List<Item> input, List<Item> expectedResults, int maxWeight) {
        this.input = input;
        this.expected = expectedResults;
        this.maxWeight = maxWeight;
    }

    @Parameterized.Parameters
    public static Collection inputs() {
        //input, expected, knapsack size
        return Arrays.asList(new Object[][] {
                //1
                {ImmutableList.of(
                        new Item(1, 5, 5),
                        new Item(2, 4, 6),
                        new Item(3, 7, 8),
                        new Item(4, 7, 4)),
                ImmutableList.of(
                        new Item(3, 7, 8),
                        new Item(4, 7, 4)),
                Integer.valueOf(13)},


                //2
                {ImmutableList.of(
                        new Item(1, 3, 2),
                        new Item(2, 7, 3),
                        new Item(3, 2, 4),
                        new Item(4, 9, 5)),
                ImmutableList.of(
                        new Item(1, 3, 2),
                        new Item(2, 7, 3)),
                Integer.valueOf(5)},

                //3
                {ImmutableList.of(
                        new Item(1, 3, 2),
                        new Item(2, 4, 3),
                        new Item(3, 5, 4),
                        new Item(4, 6, 5)),
                ImmutableList.of(
                        new Item(1, 3, 2),
                        new Item(2, 4, 3)),
                Integer.valueOf(5)}
        });
    }

    @Before
    public void setup() {
        knapsackSolver = new IntegerKnapsackSolver();
    }

    @Test
    public void solveCorrectlySolvesKnapsack1() {
        List<Item> actual = knapsackSolver.solve(input, maxWeight);

        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }
}
