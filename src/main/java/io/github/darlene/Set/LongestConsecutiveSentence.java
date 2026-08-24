package io.github.darlene.Set;

import java.util.HashSet;

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
