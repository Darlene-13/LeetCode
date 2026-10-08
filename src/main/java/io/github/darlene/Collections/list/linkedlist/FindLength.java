package io.github.darlene.Collections.list.linkedlist;


public class FindLength{

    public int findLength(ListNode head){
        int count = 0;
        ListNode current = head;
        while (current != null){
            //Increment the count.
            count++;
            current = current.next;
        }
        return count;
    }
}

