package io.github.darlene.InterviewPrep.Day1Arrays;


public class ValidPalindrome {

    public boolean isPalindrome(String s){
        s = s.toLowerCase();
        int rightPointer = s.length() - 1;
        int leftPointer = 0;
        while(leftPointer < rightPointer){
            while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(leftPointer))){
                leftPointer ++;
            }
            while (rightPointer > leftPointer && !Character.isLetterOrDigit(s.charAt(rightPointer))){
                rightPointer --;
            }

            if(s.charAt(leftPointer) != s.charAt(rightPointer)){
                return false;
            } else {
                leftPointer ++;
                rightPointer --;
            }
        }

        return true;
    }
}
