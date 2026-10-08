package io.github.darlene.Collections.list.linkedlist;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode current = slow;
        ListNode previous = null;
        while (current !=null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        ListNode first = head;
        ListNode second = previous;

        while(first !=null && second != null){
            if(first.val != second.val){
                return false;
            }

            //move pointers
            first = first.next;
            second = second.next;

        }

        return true;
    }
}
