package io.github.darlene.arrays;

public class MajorityElement{
    public int majorElement(int [] nums){
        int vote = 0, candidate = 0;
        int limit = nums.length/2;
        for(int i = 0; i < nums.length; i++){
            // If the count is zero make the current number the candidate and then make the count 1.
            if(vote == 0){
                candidate = nums[i];
                vote = 1;
            // If the candidate is the nums then increment count by 1;
            } else if (nums[i] == candidate) {
                vote ++;
            // If the candidate is not the number then decrement count by 1
            } else {
                vote --;
            }
        }

        int count = 0;
        // Count the number of candidates
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == candidate)
                count ++;
        }
        if(count > limit){
            return candidate;
        } return -1;
    }
}