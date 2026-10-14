package io.github.darlene.Collections.list.linkedlist;


public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head,int n){

        int length = 0;
        ListNode current = head;
        // Get a count or the length of the list
        while (current != null){
            length ++;
            current = current.next;
        }

        //Check whether the first node should be removed and do the necessary.
        if(length == n){
            return head.next;
        }

        current = head;
        int steps = length - n - 1;

        for(int i  = 0; i < steps; i++){
            current = current.next;
        }

        current.next = current.next.next;

        return head;
    }


    public ListNode removeNthNode(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i =0; i<=n; i++){
            fast = fast.next;
        }

        while (fast !=null){
            fast = fast.next;
            slow = slow.next;
        }


        slow.next = slow.next.next;;
        return dummy.next;
    }
}