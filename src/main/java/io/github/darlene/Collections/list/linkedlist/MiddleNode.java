package io.github.darlene.Collections.list.linkedlist;

public class MiddleNode {
    //Option 1: Two traversals
    public ListNode middleNode1(ListNode head){
        ListNode current = head;
        int count = 0;
        while(current !=null){
            count +=1;
            current = current.next;
        }

        int middle = count / 2;
        int position = 0;
        current = head;
        while (position < middle){
            current = current.next;
            position +=1;

        }
        return current;
    }
    //Option 2: Fast and slow
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
