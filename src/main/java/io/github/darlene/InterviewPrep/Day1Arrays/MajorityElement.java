package io.github.darlene.InterviewPrep.Day1Arrays;

public class MajorityElement {
    public int majorityElement(int [] nums){
        int candidate = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == candidate){
                count +=1;
            } else {
                count -=1;
            }

            if (count == 0){
                candidate = nums[i];
                count = 1;
            }
        } return candidate;
    }
}
