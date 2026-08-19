package io.github.darlene.stack;


import java.util.Stack;

public class ValidParenthesis{

    public boolean isValid(String s){
        // Create a new stack
        Stack<Character> stack = new Stack<>();
        //Iterate through the string
        for (int i = 0; i < s.length(); i++){
            // Get the current
            char current = s.charAt(i);
            if(current == '{' || current == '[' || current == '('){
                //push it to the stack
                stack.push(current);
            } else if (current == '}' || current == ']' || current == ')'){
                if (stack.isEmpty()){
                    return false;
                }

                if (current == '}' && stack.peek() != '{'){
                    return false;
                }
                if (current == ')' && stack.peek() != '('){
                    return false;
                } if (current == ']' && stack.peek() !='['){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();

    }
}