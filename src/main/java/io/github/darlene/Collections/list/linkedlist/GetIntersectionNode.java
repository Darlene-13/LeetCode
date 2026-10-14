package io.github.darlene.Collections.list.linkedlist;

public class GetIntersectionNode {
    // Intersection means that both of the lists points to the same node in memory
    // Once the lists share the node the remaining should be the same because nodes can only have one pointer
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode A = headA;
        ListNode B = headB;

        while (A != B) {
            if (A == null) {
                A = headB;
            } else {
                A = A.next;
            }

            if (B == null) {
                B = headA;
            } else {
                B = B.next;
            }

        }

        return A;
    }

}
