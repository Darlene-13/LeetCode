package io.github.darlene.linkedlist;


import java.util.Stack;

public class ValidPalindrome{

    public boolean isPalindrome(Node head){
        // Create a stack
        Stack<Integer> stack = new Stack <>();
        //Get a pointer to the head
        Node current = head;

        //Traverse the linkedlist to fill the stack
        while (current != null){
            stack.push(current.val);
            current = current.next;
        }

        //Begin from the head again
        current = head;

        while (current != null){
            if(current.val != stack.peek()){
                return false;
            }

            //Else pop the value from the stack and go to the next val

            stack.pop();
            current = current.next;

        }

        return true;



    }

    // Optimal solution
    public boolean isValidPalindrome(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the linkedlist
        Node current = slow;
        Node previous = null;

        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }


        Node first = head;
        Node second = previous;

        //Compare
        while (first != null && second != null){

            if (first.val != second.val){
                return false;
            }

            first = first.next;
            second = second.next;
        }


        return true;
    }

}