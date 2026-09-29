package io.github.darlene.PlayGround.arrays;

/**
 *  Given a 1-based indexed integer array arr[] that is sorted in non-decreasing order, along with an integer target.
 *  Find two elements in the array such that their sum is equal to target.
 *  If such a pair exists, return the indices of the two elements in increasing order.
 *  If no such pair exists, return [-1, -1].
/**
 * ALGORITHM
 1. Initialize the left pointer at the beginning of the array.
 2. Initialize the right pointer at the end of the array.
 3. While the left pointer is less than the right pointer:
 a. Calculate the sum of the elements at the two pointer positions.
 b. If the sum equals the target, return their 1-based positions.
 c. If the sum is less than the target, move the left pointer one step to the right.
 d. If the sum is greater than the target, move the right pointer one step to the left.
 4. If no pair is found, return {-1, -1}.
 */

public class TwoSumSorted {

    public int [] twoSumSorted(int [] arr, int target){
        int left = 0, right = arr.length - 1;  // indexes.
        while (left < right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == target){
                return new int [] {left + 1, right + 1};
            } else if(currentSum < target){
                left++;
            } else {
                right --;
            }
        }
        return new int[]{-1,1};
    }
}
