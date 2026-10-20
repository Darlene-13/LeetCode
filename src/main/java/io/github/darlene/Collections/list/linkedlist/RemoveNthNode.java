package io.github.darlene.Collections.list.linkedlist;

public class RemoveNthNode {
    //Let the current node be the head, set the length counter at 0
    //Iterate as long as current is not null and increase the length count
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode current = head;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }

        // Reset head
        current = head;
        int steps = length - n - 1;  // steps to the nth number
        // If the length or the last number is null return head.next
        if(length == n){
            return head.next;
        }

        for(int i = 0; i < steps; i++){
            current = current.next;
        }

        // Skip the nth value by using current.next.next
        current.next = current.next.next;

        return head;

    }
}
