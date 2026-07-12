package io.github.darlene;


import io.github.darlene.arrays.TwoSum;
import java.util.Arrays;

public class Main {
    static void main(String [] args) {

        System.out.println("This follows and implementation of the Array Data structure");

        int [] numbers = {2,7,11,15};

        System.out.println("Input array:");
        System.out.println(Arrays.toString(numbers));

        TwoSum solution = new TwoSum();

        int result [] = solution.findTwoSum(numbers, 9);

        System.out.println("Two sum indices:");
        System.out.println(Arrays.toString(result));
    }
}
