package io.github.darlene.Collections.list.linkedlist;

public class LinkedList{


    public ListNode reverseLinkedList(ListNode head){
        // Get the three pointers
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }





}