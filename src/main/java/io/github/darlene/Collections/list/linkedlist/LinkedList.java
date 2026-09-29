package io.github.darlene.Collections.list.linkedlist;

public class LinkedList{


    public Node reverseLinkedList(Node head){
        // Get the three pointers
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }





}