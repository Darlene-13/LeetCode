package io.github.darlene.String;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * ALGORITHM
 * Create a Hashmap to store the sorted characters as keys
 * HashMap <String, List<String>> map = new HashMap<>();
 * Iterate through the words in the list of string.
 * Convert the word to a character of arrays
 * Sort the characters to alphabetical order
 * Convert the sorted characters to a string key = new String(chars)
 * If the map does not contain the key, create a new Entry "map.put(key, new ArrayList<>()";
 * Otherwise if map contains the key .map.get(key).add(word) add the word to the existing key
 * At the end return the new ArrayList .......map.values();
 *
 */
public class GroupOfAnagrams{

    public List<List<String>> groupOfAnagrams(String[] strs){
        // Create a hashmap to store the anagram key and its pairs
        HashMap<String, List<String>> map = new HashMap<>();

        //Loop to see every word
        for (String word: strs){
            char [] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());

    }

}