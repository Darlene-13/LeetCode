package io.github.darlene.Collections.list.linkedlist;


/**
 * Approach
 * Int left and right are positions and not node values
 * It means start at position ie 2 and end at position 4
 *  Before we start reversing we neeed to know the node before the left
 */

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right){
        //Edge case
        if(left == right){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeLeft = dummy;
        for(int i = 1; i < left; i++){
            beforeLeft = beforeLeft.next;
        }

        ListNode current = beforeLeft.next;

        // Move nodes to the front second
        int length = right - left;
        for (int i = 0; i < length; i++){
            ListNode nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = beforeLeft.next;
            beforeLeft.next = nextNode;
        }

        return dummy.next;

    }
}
