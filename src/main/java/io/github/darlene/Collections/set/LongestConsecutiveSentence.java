package io.github.darlene.Collections.set;

import java.util.HashSet;

/**
 * Create a hashset and store the numbers in the hashset
 * Initialize the variable to store the longest.
 * Iterate through the numbers in the set
 * If the set does not contain the current number - 1 then it qualifies to be the starting point
 * Get the current number and increment the length to be one.
 * While the current set contains the current number + 1 they can form a sequence
 * Increment the current and length
 * Get the maximum using math. Max
 * return the maximum length
 */

public class LongestConsecutiveSentence {
    public int longestConsecutive(int[] nums){

        // Create a set
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            //Add it to the set
            set.add(nums[i]);
        }

        int longest = 0;

        for (int num: set){
            if(!set.contains(num - 1)){
                int current = num;
                int length = 1;

                while (set.contains(current + 1)){
                    current ++;
                    length ++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

}
