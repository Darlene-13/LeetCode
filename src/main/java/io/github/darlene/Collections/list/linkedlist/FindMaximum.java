package io.github.darlene.Collections.list.linkedlist;

public class FindMaximum {

    public int findMax(ListNode head){
        if (head == null){
            return 0;
        }

        ListNode current = head;
        int currentMax = head.val;

        while (current !=null){
            currentMax = Math.max(currentMax, current.val);
            current = current.next;
        }

        return currentMax;
    }
}
