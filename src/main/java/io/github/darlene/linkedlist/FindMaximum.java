package io.github.darlene.linkedlist;

public class FindMaximum {

    public int findMax(Node head){
        if (head == null){
            return 0;
        }

        Node current = head;
        int currentMax = head.val;

        while (current !=null){
            currentMax = Math.max(currentMax, current.val);
            current = current.next;
        }

        return currentMax;
    }
}
