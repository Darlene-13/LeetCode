package io.github.darlene.InterviewPrep.Day1Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int[] nums2, int n, int m){
        int lastNums1 = m - 1;
        int lastNums2 = n - 1;
        int lastNumsMerged = m + n - 1;

        while(lastNums2 >= 0){
            if(lastNums1 < 0){
                nums1[lastNumsMerged] = nums2[lastNums2];
                lastNumsMerged --;
                lastNums2 --;
            } else if (nums1[lastNums1] < nums2[lastNums2]){
                nums1[lastNumsMerged] = nums2[lastNums2];
                lastNumsMerged --;
                lastNums2 --;
            } else {
                nums1[lastNumsMerged] = nums1[lastNums1];
                lastNumsMerged --;
                lastNums1 --;
            }

        }

    }
}


//Questions
/**
 * 1. what if either is empty
 * 2. If 1 is empty just return 2 and vice versa
 * 3. We only loop if 2 still has values otherwise return 1
 */