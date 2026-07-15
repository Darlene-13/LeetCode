package io.github.darlene.arrays;

public class MajorityElement{
    public int majorElement(int [] nums){
        int voteCount = 0, candidate = 0;
        for(int num: nums){
            // If the count is zero make the current number the candidate and then make the count 1.
            if(voteCount == 0){
                candidate = num;
                voteCount = 1;
            // If the candidate is the nums then increment count by 1;
            } else if (num == candidate) {
                voteCount ++;
            // If the candidate is not the number then decrement count by 1
            } else {
                voteCount --;
            }
        }
        return candidate;
    }

    // Better approach
    public int majorityElements(int [] nums){
        int candidate = 0, voteCount = 0;
        for(int num:nums){
            if(voteCount == 0) candidate = num;
            //
            voteCount += (num == candidate) ? 1: -1;
        }
        return candidate;
    }
}