package io.github.darlene.PlayGround.arrays;

import java.util.HashSet;

public class RemoveDuplicates{

    // Naive approach with poor space complexity
    public int removeDuplicates(int [] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int k = set.size();
        return k;
    }

    // Better approach using two pointer techniques
    public int removeDuplicatesTwoPointer(int nums[]){
        int writeIndex = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i -1]){
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }
}