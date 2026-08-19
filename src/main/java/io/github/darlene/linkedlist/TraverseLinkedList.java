package io.github.darlene.linkedlist;


public class TraverseLinkedList{

    public void printList(Node head){
        Node current = head;

        while (current != null){
            System.out.print(current.val + "->");
            current = current.next;
        }
    }


}

