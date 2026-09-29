package io.github.darlene.Collections.list.linkedlist;

// class ListNode{
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
    public Node reverseList(Node head){
        // Define the curr, prev, next
        Node curr = head;
        Node prev = null;
        Node next;

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

