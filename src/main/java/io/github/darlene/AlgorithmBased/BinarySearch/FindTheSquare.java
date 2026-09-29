package io.github.darlene.AlgorithmBased.BinarySearch;

public class FindTheSquare{
    public int mySqrt(int x){
        //Find the upper and lower limits in the range of 0 to x
        // Use long to prevent buffer overflow
        long low = 0;
        long high = x;
        while (low <= high){
            long mid = low + ((high - low)/2);
            long val = mid * mid;
            if (val == x){
                int sqrt = (int) mid;
                return sqrt;
            } else if (val > x){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        int myVal = (int) low -1;
        return myVal;
    }
}