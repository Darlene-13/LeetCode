# LIST

This folder contains my notes and practice code for the **List** interface, mainly `ArrayList`.

For the theory behind the List interface and its implementations, see [List.md](List.md).

## Subfolders

* [arrays/](arrays/README.md) -> array problems.
* [linkedlist/](linkedlist/README.md) -> linked list problems.
* [stack/](stack/README.md) -> stack problems.

---

## 1. ARRAYLIST IMPLEMENTATION

* `ArrayListImplementation.java` holds my notes on how an `ArrayList` works internally, together with examples of the basic operations.

* The class comment explains what an `ArrayList` is:

    * It implements the `List` interface, which is a sub-interface of `Collection`.
    * It is a **resizable array**, so it grows and shrinks as elements are added or removed.
    * Elements are accessed by index, duplicates are allowed, and insertion order is kept.
    * It is **not thread-safe**. To make it thread-safe I can wrap it with `Collections.synchronizedList()`.

* The method `createArrayList` shows:

    * `list.add(value)` -> appends to the end.
    * `list.add(index, value)` -> inserts at a position and shifts the later elements to the right.
    * `list.remove(index)` -> removes by position.
    * `list.remove(Integer.valueOf(1))` -> removes by value. I need `Integer.valueOf` here because `remove(1)` on an `ArrayList<Integer>` would be read as an **index**.
    * `arr.remove("Wendy")` -> removes by value on a `String` list, where there is no index/value confusion.
    * `list.set(index, value)` -> replaces the value at a position.

* My notes on the internal implementation:

    * It is backed by a **dynamic array** stored in contiguous memory, which is why `get(index)` is `O(1)`.
    * Its default capacity is `10`.
    * When the internal array is full, it creates a larger array (`newCapacity = oldCapacity + oldCapacity / 2`) and copies the elements across.

* **Complexity of each operation:**

    * Insertion at the end -> `O(1)` amortized time.
    * Insertion at a specific index -> `O(n)` time, because later elements shift right.
    * Removing an element -> `O(n)` time, because later elements shift left.
    * Replacing an element (`set`) -> `O(1)` time.
    * Accessing by index (`get`) -> `O(1)` time.
    * Traversing -> `O(n)` time.
    * All of these use `O(1)` extra space.

* **Note:** `createArrayList(String[] args)` is not a `main` method, so this class cannot be run on its own. Also, `arr.remove(1)` already removes `"Wendy"`, so the following `arr.remove("Wendy")` does nothing.

---

## 2. ARRAYLIST PRACTICE

* `ArrayListPractice.java` is a runnable `main` method where I practice the `ArrayList` API, grouped by purpose:

    * **Adding:** `add(E)`, `add(index, E)`, `addAll(Collection)`, `addAll(index, Collection)`.
    * **Accessing / checking:** `get(index)`, `size()`, `isEmpty()`, `contains(Object)`, `indexOf(Object)`, `lastIndexOf(Object)`.
    * **Modifying:** `set(index, E)`.
    * **Removing:** `remove(index)`, `remove(Object)`, `clear()`, `removeAll(Collection)`, `removeIf(Predicate)`.
    * **Keeping:** `retainAll(Collection)` -> keeps only the elements that are also in the given collection.
    * **Traversing:** an enhanced `for` loop and `forEach` with a lambda.
    * **Converting:** `toArray()` returns an `Object[]` and `toArray(new Integer[0])` returns a typed `Integer[]`.
    * **Sublist:** `subList(from, to)` returns a view of part of the list.

* **Complexity of the operations used:**

    * `get`, `set`, `size`, `isEmpty` -> `O(1)`.
    * `add(E)` -> `O(1)` amortized. `add(index, E)` and `addAll(index, ...)` -> `O(n)` because of shifting.
    * `contains`, `indexOf`, `lastIndexOf` -> `O(n)` because they scan the list.
    * `remove(index)` / `remove(Object)` -> `O(n)`.
    * `removeAll`, `retainAll` -> `O(n · m)` here, because each element is checked against another `ArrayList` of size `m`.
    * `removeIf`, `clear`, traversal, `toArray` -> `O(n)`.
    * `subList` -> `O(1)`, because it is a view and not a copy.

* **Note:** some of the expected-output comments do not match what the code prints:

    * After the `add(index, ...)` calls and `addAll(other)`, `list` is `[1, 99, 98, 97, 96, 95, 2, 3, 4, 5, 40, 50]`. Inserting at an index **shifts** values and does not overwrite them.
    * `numbers.set(1, 99)` gives `[1, 99, 3, 4, 5, 3]`, not `[1, 2, 99, 4, 5, 3]`. This also changes the results of the next steps.
    * `removeAll([2, 4])` on `[1, 2, 3, 2, 4, 2]` gives `[1, 3]`, because every occurrence is removed.
    * In `subList(from, to)`, `from` is **inclusive** and `to` is **exclusive** (the comment has these reversed).
    * `numbers.removeIf(...)` runs after `numbers.clear()`, so it works on an empty list.

---

## 3. LINKEDLIST IMPLEMENTATION / LINKEDLIST PRACTICE

* `LinkedListImplementation.java` and `LinkedListPractice.java` are empty placeholders for now (`LinkedListPractice` only has an empty `main`).

* My linked list problems are in [linkedlist/](linkedlist/README.md).
