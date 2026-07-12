package io.github.darlene.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    @Test
    void example1() {
        assertArrayEquals(
                new int[]{0, 1},
                twoSum.findTwoSum(new int[]{2, 7, 11, 15}, 9)
        );
    }

    @Test
    void example2() {
        assertArrayEquals(
                new int[]{1, 2},
                twoSum.findTwoSum(new int[]{3, 2, 4}, 6)
        );
    }

    @Test
    void example3() {
        assertArrayEquals(
                new int[]{0, 1},
                twoSum.findTwoSum(new int[]{3, 3}, 6)
        );
    }

    @Test
    void negativeNumbers() {
        assertArrayEquals(
                new int[]{0, 2},
                twoSum.findTwoSum(new int[]{-3, 4, 1}, -2)
        );
    }

    @Test
    void shouldThrowExceptionWhenNoSolutionExists() {
        assertThrows(
                IllegalArgumentException.class,
                () -> twoSum.findTwoSum(new int[]{1, 2, 3}, 100)
        );
    }
}