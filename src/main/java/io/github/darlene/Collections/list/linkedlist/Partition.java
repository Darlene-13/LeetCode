package io.github.darlene.Collections.list.linkedlist;

public class Partition {

    public ListNode partition(ListNode head, int x){
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        ListNode current = head;

        while(current !=null){

            if(current.val < x){
                small.next = current;
                small = small.next;
            } else{
                large.next = current;
                large = large.next;
            }

            current = current.next;
        }

        // Connect the two dummys
        large.next = null;
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}
