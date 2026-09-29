package io.github.darlene.PlayGround.arrays;

/**
 *  ALGORITHM
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class MedianSortedArrays{
    public double findMedian(int [] nums1, int [] nums2){
        // Concatenate the array to 1
        int [] arr = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        //Sort the array
        int [] sortedArr = Arrays.stream(arr).sorted().toArray();
        double median = 0;
        if(sortedArr.length % 2 != 0){
            int num =  sortedArr.length/2;
            median = sortedArr[num];
        } else {
            // Not so sure if they should be stored in an array or individual integers
            int num1 = sortedArr.length/2 ;
             double numa = sortedArr[num1];
            int num2 = sortedArr.length/2 - 1;
            double numb = sortedArr[num2];
            median =  (numa + numb) /2;
        }
        return median;

    }

    // Better  approach
    public double findMedianSortedArrays(int [] nums1, int [] nums2){
        // Always ensure that num1 is the smaller array
        if (nums1.length > nums2.length){
            //Swap
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int leftSize = (m + n + 1)/2;

        int low = 0;
        int high = m;

        // Binary search
        while (low <= high){
            int partition1 = (low + high) /2;
            int partition2 = leftSize - partition1;

            // Define the boundaries
            int L1, L2, R1, R2;

            //L1 value immediately to the left of partition1
            if (partition1 == 0){
                L1 = Integer.MIN_VALUE;
            } else {
                L1 = nums1[partition1 - 1];
            }

            //R1 value immediately to the right of partition 1
            if (partition1 == m){
                R1 = Integer.MAX_VALUE;
            } else {
                R1 = nums1[partition1];
            }

            // L2: value immediately to the left of partition2
            if (partition2 == 0) {
                L2 = Integer.MIN_VALUE;
            } else {
                L2 = nums2[partition2 - 1];
            }

            // R2: value immediately to the right of partition2
            if (partition2 == n) {
                R2 = Integer.MAX_VALUE;
            } else {
                R2 = nums2[partition2];
            }

            if (L1 > R2){
                high = partition1 - 1;
            } else if (L2 > R1){
                low = partition1 + 1;
            } else {
                if ((m + n) % 2 == 1){
                    return Math.max(L1, L2);
                }

                return (Math.max(L1,L2) + Math.min(R1, R2))/2.0;
            }

        }
        return 0.0;

    }

}
