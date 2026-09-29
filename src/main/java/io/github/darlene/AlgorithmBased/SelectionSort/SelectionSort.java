package io.github.darlene.AlgorithmBased.SelectionSort;

import java.util.ArrayList;

public class SelectionSort{
    public static int findSmallest(ArrayList<Integer> arr){
        int smallest = arr.get(0);
        int smallestIndex = 0;
        //Length of the array
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) < smallest){
                smallest = arr.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    // Function to build and return the sorted array
    public static ArrayList<Integer> selectionSorting(ArrayList<Integer> arr){

        ArrayList<Integer> list = new ArrayList<>();
         int size = arr.size();
         for(int i = 0; i < size; i++){
             int smallestIndex = findSmallest(arr);
             list.add(arr.remove(smallestIndex));
         }

         return list;
    }

}