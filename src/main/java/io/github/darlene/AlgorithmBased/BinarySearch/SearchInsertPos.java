package io.github.darlene.AlgorithmBased.BinarySearch;

public class SearchInsertPos{
    public int search(int [] nums, int target){
        //Define the lowest and highest limits
        int low = 0, high = nums.length - 1;
        while (low <= high){
            //Find the middle value
            int mid = low + ((high - low)/2);
            if(mid == target){
                return mid;
            } else if(mid > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int position = low + ((high - low));
        return position;
    }



    public int seachInsert(int [] nums, int target){
        int low = 0; int high = nums.length - 1;
        while (low <= high){
            int mid = low + ((high - low)/2);
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return low;
    }
}