package io.github.darlene.linkedlist;

//class ListNode{
//    int val;
//    ListNode next;
//
//    ListNode(int val){
//        this.val = val;
//    }
//    ListNode(int val, ListNode next) {
//        this.val = val; this.next = next;
//    }
//}
public class ReverseLinkedList{
    // Method to reverse a linked list
    public ListNode reverseList(ListNode head){
        // Define the curr, prev, next
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr !=null){
            //store next
            next = curr.next;
            //Reverse the currents pointer to prev
            curr.next = prev;
            //Now shift the pointers
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

