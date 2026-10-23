package io.github.darlene.Collections.list.stacks_and_queues;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int [] temps){
        //We use stack to avoid O(n^2) through repeatedly scanning the same temperatures
        //Stack is a LIFO data structure
        int[] answer = new int[temps.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temps.length; i++){
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]){
                int previous = stack.pop();
                answer[previous] = i - previous;
            }

            stack.push(i);
        }

        return answer;
    }


    public int [] findTemps(int [] temperatures){
        Stack<Integer> stack = new Stack<>();
        int [] answer = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int previous = stack.pop();
                answer[previous] = i - previous;
            }
            stack.push(i);
        }

        return answer;
    }
}
