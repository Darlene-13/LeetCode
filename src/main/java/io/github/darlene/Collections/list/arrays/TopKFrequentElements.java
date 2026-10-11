package io.github.darlene.Collections.list.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Frequency is the Value.
public class TopKFrequentElements {

    public int[] topKFrequent(int [] nums, int k){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
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
}
