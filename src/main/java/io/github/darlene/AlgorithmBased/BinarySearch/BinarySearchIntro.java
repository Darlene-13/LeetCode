package io.github.darlene.AlgorithmBased.BinarySearch;

public class BinarySearchIntro{
    public int binarySearch(int [] arr, int item){
        // Define the low and high of the array
        int low = 0, high = arr.length -1;
        //Iterate to find the item
        while (low <= high){
            // Find the middle
            int mid = low + ((high - low)/2);
            if (arr[mid] == item){
                System.out.println("Found the item: " + item);
                return mid;
            } else if (arr[mid]> item){
                high = mid -1;
            } else{
                low = mid + 1;
            }
        }
        // Return item not found
        return -1;
    }

    // Method to find the number of steps it woud take
}


// ALGORITHM STEPS
//Define the lowest and highest points of the array (position wise)
//While the lowest point is lesser than the highest then we can iterate
// But to make our work easier with binary search find the mid array low + (high - low)/2
//Compare if the item or number == arr[mid] or the middle item if not adjust the low and high points.
//If the item > arr[mid] make the low = mid + 1 and if it is less than mid make high = mid - 1 and then iterate till we find the value.

