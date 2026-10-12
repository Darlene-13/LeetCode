package io.github.darlene.Collections.list.arrays;

import java.util.*;

//Frequency is the Value.
public class TopKFrequentElements {

    // Achieves O(NlogK)
    public int[] topKFrequent(int [] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // Create a min heap max and give it a comparator
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        int[] result = new int[k];
        for (int num: map.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        for (int j = 0; j <k; j++){
            result[j] = minHeap.poll();
        }
        return result;

    }


    //Using a bucket sort method that achieves O(N)
    public int[] topKFrequent1(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int arrLength = nums.length - 1;
        int [] result = new int[k];
        int index = 0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        List<Integer>[] buckets = new List[arrLength];
        //Placing each number in the correct bucket
        for(int num: map.keySet()){
            int freq = map.get(num);

            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        for (int freq = buckets.length - 1; freq >= 1 && index <k; freq --){
            if(buckets[freq] != null){
                for(int num: buckets[freq]){
                    result[index++] = num;

                    if(index == k){
                        break;
                    }
                }
            }
        }
        return result;
    }
}
