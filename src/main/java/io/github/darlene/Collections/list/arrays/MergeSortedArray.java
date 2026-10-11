package io.github.darlene.Collections.list.arrays;


public class MergeSortedArray{

    public void merge(int [] nums1, int m, int [] nums2, int n){
        // Use three pointers to keep tab of both nums
        int lastNums1 = m - 1; // last number at nums 1
        int nums1Right = m + n - 1; // Length of nums 1
        int lastNums2 = n - 1; // last number at  nums 2 and length of nums 2

        //Check if there are still elements at nums 2, the pointer should point to - 1
        while (lastNums2 >= 0){

            if (lastNums1 < 0){
                nums1[nums1Right] = nums2[lastNums2];
                lastNums2 --;
            } else if (nums1[lastNums1] > nums2[lastNums2]){
                nums1[nums1Right] = nums1[lastNums1];
                lastNums1 --;
            } else {
                nums1[nums1Right] = nums2[lastNums2];
                lastNums2--;
            }

            nums1Right --;
        }
    }
}