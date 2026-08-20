package io.github.darlene.OnePassSolutions;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s){
        int lastChar = s.length() - 1;
        int length = 0;

        // Ensure to skip all spaces
        while (s.charAt(lastChar) == ' '){
            lastChar --;
        }

        // Count the letters of the last word
        while (lastChar >= 0 && s.charAt(lastChar) != ' '){
            length ++;
            lastChar --;
        }

        return length;
    }
}
