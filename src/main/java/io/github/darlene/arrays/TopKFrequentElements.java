package io.github.darlene.arrays;

import java.util.*;

// Naive approach
//public class TopKFrequentElements {
//    public int[] topKFrequent(int [] nums, int k){
//        // Initialize a hashmap to store frequencies
//        Map <Integer, Integer> map = new HashMap<>();
//        //Iterate through the nums array to populate the map
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.getOrDefault(num, 0) + 1);
//            }
//        }
//        //Convert the map to an array for sorting.
//        // Populate using the .entry from the
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//        System.out.println("The entry set it: " + list);
//
//        // sort using a comparator
//        list.sort(Comparator.comparing(entry -> list::getValue() ));
//
//
//
//    }
//}


// Bucket method





// Min heap algorithm.