package io.github.darlene.InterviewPrep.Day1Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int [] result = new int[nums.length];
        int product = 1;
        int rightPointer = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            result[i] = product;
            product = product * nums[i];
        }
        //Product reset
        product = 1;

        for (int i = rightPointer; i >= 0; i--) {
            result[i] = result[i] * product;
            product = product * nums[i];
        }
        return result;
    }

}
