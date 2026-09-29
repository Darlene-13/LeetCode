package io.github.darlene.Collections.list.stack;

import java.util.Stack;

public class MinStack {

    // Create the push stack and stack to keep minimum values
    Stack <Integer> values;
    Stack<Integer> min;
    public MinStack(){
        values = new Stack<>();
        min = new Stack<>();
    }

    public void push(int value){
        //Push into values
        values.push(value);
        if (min.isEmpty()){
            min.push(value);
        } else {
            Integer minimum = Math.min(value, min.peek());
            min.push(minimum);
        }

    }

    public void pop(){
        values.pop();
        min.pop();
    }

    public int top(){
        return values.peek();
    }

    public int getMin(){
        return min.peek();
    }
}
