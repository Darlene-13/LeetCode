package io.github.darlene.arrays;

public class MoveZeros{
    public void moveZeros(int [] nums){
        // Track the position of the left most box that needs values..
        int posZero = 0;
        for (int i  = 0; i <nums.length; i++){
            if(nums[i] !=0){
                if( i!= posZero){
                    // Take the value at position i and fill it in the current empty slot.
                    nums[posZero] = nums[i];
                    nums[i] = 0;
                }
                posZero++;
            }
        }
    }
}