package io.github.darlene.Collections.list.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;

// Implement a FIFO data structure using a LIFO data structure
public class MyQueues {
    private Deque<Integer> input;
    private Deque<Integer> output;
    public MyQueues{
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }

    public void push(int x){
        input.push(x);
    }


    private void transfer(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
    }

    public int pop(){
        transfer();
        return output.pop();
    }

    public int peek(){
        transfer();
        return output.peek();
    }

    public boolean empty(){
        return input.isEmpty() && output.isEmpty();
    }
}
