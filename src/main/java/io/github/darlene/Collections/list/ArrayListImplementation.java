package io.github.darlene.Collections.list;

import java.util.ArrayList;

/**
 * IT IMPLEMENTS THE LIST INTERFACE WHICH IS A SUB INTERFACE OF THE COLLECTION INTERFACE
 * This is a resizable array in the util package
 * When we say resizable we mean it can grow and shrink dynamically as elements are added or removed.
 * Similar to arrays elements can be accessed using their indexes
 * Duplicates are allowed
 * The order of insertion is maintained
 * The arraylist is not threadsafe -> to make it thread safe we could make use of Collections.synchronizedList()
 */


public class ArrayListImplementation {

    public static void createArrayList(String[] args){
        //Creating a new arraylist
        ArrayList<Integer> list = new ArrayList<>();

        //Adding elements to the arraylist
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //Creating an arraylist that is initialized with elements from a certain collection
        //ArrayList<String> arr = new ArrayList<>(collection);
        //Creating an arraylist of pre-defined capacity
        //ArrayList<String> arr = new ArrayList<>(20);

        //Adding elements for a specific index
        list.add(1, 2);
        list.add(2, 1);
        list.add(3, 3);
        list.add(4, 4);

        //Removing elements in an arraylist using index
        list.remove(1);
        list.remove(2);
        list.remove(4);

        //Removing element using value
        list.remove(Integer.valueOf(1));
        //If it were an arraylist of string ir
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Darlene");
        arr.add("Wendy");
        arr.add("Stacy");

        arr.remove(1);
        arr.remove("Wendy");

        //Updating the value
        list.set(1, 8);
        arr.set(1, "Nasimiyu");

        // Methods in arraylist
        //list.add(int index, Object element) : Adds the specified element at the specified position index in the ArrayList, elements from that position onwards are shifted to the right.
        //list.add(Object o): Appends the specified elements to the end of the arraylist.
        //list.addAll(Collection C): Append elements from a specified collection
        //addAll(int index, Collection c)
        //clear: remove all elements from any list
        //clone: return a shallow copy of the arraylist.
        //contains(Object o): checks the value not the index
        //ensureCapacity(int minCapacity): increases the capacity if necessary.
        //forEach(Consumer<?super E>action)
        //getIndex()


    }

}


// * INTERNAL IMPLEMENTATION
// * 1. Uses a dynamic array data structure
// * 2. Automatic resizing: when the internal array is full it automatically increases its capacity by creating a new larger array
// * and copying the existing elements into it.
// * 3. Index based access: Elements are stored in contiguous memory location allowing fast access using indexes ie getIndex() which has 0(1) time complexity
// * 4. Gets initialized with a default capacity of 10.
// * 5. New cap = Old cap + (old cap/2);
// *
// * Insertion at the end: o(1) in both time and space
// * Insertion at a specific index o(n) in time and o(1) in space
// * Removing elements o(n) in time and o(1) in space.
// * Replacing elements o(1) in time and o(1) in space.
// * Traversing elements 0(n) in time and 0(1) in space.
// *



