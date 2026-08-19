package io.github.darlene.linkedlist;


public class FindLength{

    public int findLength(Node head){
        int count = 0;
        Node current = head;
        while (current != null){
            //Increment the count.
            count++;
            current = current.next;
        }
        return count;
    }
}

