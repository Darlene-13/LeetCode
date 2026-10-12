package io.github.darlene.Collections.list.arrays;

import java.util.*;

public class TopKFrequentWords{
    public List<String> topKFrequent(String[] words, int k){

        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> {
            int frequencyComparison = map.get(a) - map.get(b);

            if(frequencyComparison == 0){
                return b.compareTo(a);
            }

            return frequencyComparison;
        });
        List<String> result = new ArrayList<>(k);

        for(String word: map.keySet()){
            minHeap.offer(word);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }

        Collections.reverse(result);

        return result;
    }
}