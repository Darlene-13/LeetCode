package io.github.darlene.TwoPointer;

public class ValidPalindrome {
    public boolean isPalindrome(String s){
        s = s.toLowerCase();
        //Two pointers for the start and the end
        int left = 0;
        int right = s.length() - 1;

        while (left < right){

            // Skip invalid characters
            while ( left < s.length() && !Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }
            while ( right >= 0 &&!Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }

            if (left >= right){
                break;
            }

            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left ++;
            right --;

        }

        return true;
    }
}
