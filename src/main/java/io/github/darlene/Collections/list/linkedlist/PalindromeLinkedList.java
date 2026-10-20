package io.github.darlene.Collections.list.linkedlist;

public class PalindromeLinkedList{
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode current = slow;
        ListNode prev = null;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode first = head;
        ListNode second = prev;
        while (first != null && second !=null){
            if (first.val != second.val) {
                return false;
            }

            first = first.next;
            second = second.next;

        }
        return true;

    }
}