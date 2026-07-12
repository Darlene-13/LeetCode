package io.github.darlene.arrays;


/**
 *  ALGORITHM
 *  1. Create an empty HashMap
 *  2. Iterate through the given arr
 *  3. For each number in the array, find its complement (target - currentInteger)
 *  4. Check whether its complement exists in the map
 *  5. If it does return the stored index together with its index in the map;
 *  6. Otherwise, store the current number and its index in the map
 *  7. If no pair is found throw and exception argument;
 */

// Maps allows us to look up by key.

import java.util.Map;
import java.util.HashMap;

public class TwoSum{

    // Method to find the two sum of a given array
    public int[] findTwoSum(int [] arr, int target){
        // Create a hashmap
        Map<Integer, Integer> twosum = new HashMap<>();
        // Iterate through the array
        for (int i = 0; i < arr.length; i++){
            int complement = target - arr[i];
            Integer complementIndex = twosum.get(complement);
            if(complementIndex !=null){
                return new int[] {complementIndex, i};
            }
            twosum.put(arr[i], i);
        }

        throw new IllegalArgumentException ("No two sum solution");
    }
}