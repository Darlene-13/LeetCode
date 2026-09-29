package io.github.darlene.InterviewPrep.Day1Arrays;

//Identify input, output, algorithm to use, data structures

import java.util.HashMap;

/**
 *  Input: Array of integer nums and a target
 *  Output: Array of indices of two numbers that sum up to the target.
 *  We will use just like One pass method where we iterate once through the array as we do the computation.
 *  DS: Hashmap cause we need to return an array of indices, so to keep track of an indices of a number we use a map
 */
public class TwoSum{
    public int[] twoSum(int [] nums, int target){
        HashMap<Integer, Integer> twoSum = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            Integer complementIndex = twoSum.get(complement);

            if(complementIndex !=null){
                return new int[]{complementIndex, i};
            }

            twoSum.put(nums[i], i);
        }

        return new int[0];
    }

}