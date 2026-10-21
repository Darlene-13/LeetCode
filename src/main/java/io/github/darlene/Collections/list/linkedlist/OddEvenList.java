package io.github.darlene.Collections.list.linkedlist;

/**
 * My thoughts
 *  What makes a value odd is if node.val % 2 != 0;
 *  So we do this create a dummy node then start witht he first one
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head){

        // Edge case
        if(head == null || head.next == null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even !=null && even.next != null){

            //Connect the odd to the next odd positioned  node
            odd.next = even.next;
            odd = odd.next;

            //connect the even to the next even positioned node
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;


        return head;

    }
}
