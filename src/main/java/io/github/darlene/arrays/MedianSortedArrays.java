package io.github.darlene.arrays;

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



//    // Re -write
//    public double medianOfSortedArray(int [] nums1, int [] nums2){
//        //Concatenate the two arrays to one array
//        int [] arr = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
//        //Sort the array
//        int [] sortedArr = Arrays.stream(arr).sorted().toArray();
//        //Initialize median
//        double median = 0;
//        //For odd cases
//        if (sortedArr.length % 2 != 0){
//            int num = sortedArr.length/2;
//            median = sortedArr[num];
//        } else {
//            int num1 = sortedArr.length /2;
//            double numa = sortedArr[num1];
//            int num2 = sortedArr.length/2 - 1;
//            double numb = sortedArr[num2];
//            median = (numa + numb) /2 ;
//        }
//        return median;
//
//    }
}
