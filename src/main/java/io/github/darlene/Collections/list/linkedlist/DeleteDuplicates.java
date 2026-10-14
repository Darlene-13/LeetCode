package io.github.darlene.Collections.list.linkedlist;



public class DeleteDuplicates{
    public ListNode deleteDuplicates(ListNode head){
        ListNode current = head;

        while(current != null && current.next != null){
            if(current.val == current.next.val){
                // Skip the current value
                current.next = current.next.next;
            } else {
               current = current.next;
            }
        }

        return head;
    }
}