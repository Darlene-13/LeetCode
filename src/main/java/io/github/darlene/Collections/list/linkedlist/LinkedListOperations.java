package io.github.darlene.Collections.list.linkedlist;

/**
 *
 */
public class LinkedListOperations {

    Node dummy;
    int size;

    LinkedListOperations(){
        dummy = new Node(-1);
        size = 0;
    }

    // Method to insert at the head
    void insertAtHead(int val){
        Node newNode = new Node(val);
        newNode.next = dummy.next; // always points to the real first node.
        dummy.next = newNode;
        size++;

    }

    //Insert at tail
    //Any time we insert we need to create a new Node that takes in any value
    void insertAtTail(int val){
        Node newNode = new Node(val);
        Node curr = dummy;

        //We can only insert if it is null, we always insert at the dummy
        while(curr.next != null){
            curr = curr.next; //walks until curr == last node.
        }

        curr.next = newNode;
        size++;
    }

    // Delete a node by value
    void delete(int val){
        Node curr = dummy;
        while (curr.next !=null && curr.next.val != val){
            curr = curr.next;
        }

        if(curr.next !=null){
            curr.next = curr.next.next;  //skip over the node to delete
            size--;
        }
    }


    //Traversal/ print for debugging......
    void traverseLinkedList(){
        Node curr = dummy.next; // We do not start from the dummy
        StringBuilder sb = new StringBuilder();
        while (curr != null){
            sb.append(curr.val).append("->");
            curr = curr.next;
        }

        sb.append("null");
        System.out.println(sb.toString());
    }

}

