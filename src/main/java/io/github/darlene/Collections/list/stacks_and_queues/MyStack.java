package io.github.darlene.Collections.list.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Queue;

//Implement a LIFO data structure using a FIFO data structure
public class MyStack {
    private Queue<Integer> queue;
    public MyStack(){
        queue = new ArrayDeque<>();
    }

    public void push(int x){
        //Use queue.offer
        queue.offer(x);
        int size = queue.size();
        //Move all the previous behind the new element.
        for (int i = 0; i < size - 1; i++){
            queue.offer(queue.poll());
        }
    }

    public int pop(){
        //Remove the top element
        return queue.poll();
    }

    public int top(){
        //Return the top element
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
}
