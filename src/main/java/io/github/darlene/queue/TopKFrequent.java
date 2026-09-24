package io.github.darlene.queue;


import java.lang.classfile.constantpool.IntegerEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent{

    public int[] topKFrequent(int [] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        // A priority queue naturally sorts by the descending order
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue()));
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);

            if (pq.size() > k){
                pq.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++){
            result[i] = pq.poll().getKey();
        }

        return result;
    }


    public int [] topKFreq(int [] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        // Create a priority queue
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(
                        (entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue())
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int [] result = new int[k];
        for (int i = 0; i < k; i++){
            result [i] = pq.poll().getKey();
        }
        return result;
    }










}