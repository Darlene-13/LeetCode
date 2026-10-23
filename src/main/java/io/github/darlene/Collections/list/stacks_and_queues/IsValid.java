package io.github.darlene.Collections.list.stacks_and_queues;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s){
        //Create a new Stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            // Get the first character
            char current = s.charAt(i);
            if(current == '{' || current == '[' || current == '('){
                stack.push(current);
            } else if (current == '}' || current == ']' || current == ')'){
                if (stack.isEmpty()){
                    return false;
                }

                if (current == '}' && stack.peek() != '{'){
                    return false;
                }
                if (current == ']' && stack.peek() != '['){
                    return false;
                }

                if (current == ')' && stack.peek() != '('){
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
