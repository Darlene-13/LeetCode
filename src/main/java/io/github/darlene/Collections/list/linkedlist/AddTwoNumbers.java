package io.github.darlene.Collections.list.linkedlist;


/**
 * ALGORITHM
 * We have three params to track the carry value, the digit to write down and the sum
 * Create a dummy to start us at the new output
 * Initialize the carry variable to 0
 * Iterate within the boundaries of when: list node 1 and  2 is not null and carry is not equal to 0
 * Get the values of l1 and l2 and when either is null we equal it to zero
 * Get the num of l1 and l2
 *
 */
public class AddTwoNumbers{

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //First step is to create  dummy to start us at our new output
        ListNode dummy = new ListNode(0);
        // Get a current value pointer
        ListNode curr = dummy;

        //initialize the carry variable with 0
        int carry = 0;
        //Iterate
        while (l1 !=null || l2 !=null || carry != 0){
            // Get the values of both l1 and l2 and when either is null the value should then be 0
            int x = (l1 !=null) ? l1.val: 0;
            int y = (l2 !=null) ? l2.val: 0;

            // Get the sum
            int sum =  x + y + carry;
            int digit = sum % 10; // What we write down.
            carry = sum/10;

            if(l1 !=null) l1 = l1.next;
            if(l2 !=null) l2 = l2.next;

            curr.next = new ListNode(digit);
            curr = curr.next;


        }

        return dummy.next;
    }
}


