package io.github.darlene.AlgorithmBased.SlidingWindow;

import javax.naming.directory.Attribute;
import java.util.HashSet;

/**
 * Create an empty hashshet
 */
public class LongestSubstring{
    public int lengthOfTheLongestSubstring(String s){

        HashSet <Character> set = new HashSet<>();
        //Initialize left pointer at 0
        int leftPointer = 0;
        int maxLength=0;

        //Iterate through the string
        for (int i = 0; i < s.length(); i++){
            //Confirm if the character is at the set and then remove it and continue.
            while (set.contains(s.charAt(i))){
                set.remove(s.charAt(leftPointer));
                leftPointer++;
            }

            //Add to the set
            set.add(s.charAt(i));
            int length = i - leftPointer + 1;
            maxLength = Math.max(maxLength, length);

        }
        return maxLength;
    }


    // Optimal solution
    public int lengthOfLongestSubString(String s){
        int maxLength = 0, leftPointer = 0;
        int [] lastSeen = new int[128];
        for (int right = 0; right < s.length(); right++){
            leftPointer = Math.max(leftPointer, lastSeen[s.charAt(right)]);
            maxLength = Math.max(maxLength, right - leftPointer + 1);
            lastSeen[s.charAt(right)] = right + 1;

        }

        return maxLength;

    }


}