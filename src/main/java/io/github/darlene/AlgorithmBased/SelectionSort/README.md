# DOCUMENTATION OF SELECTION SORT

## 1. SELECTION SORT

* The approach I use is a **find-the-smallest-and-move-it** selection sort, split into two methods.

* `findSmallest(arr)`:

    * I assume the first element is the smallest, storing it in `smallest` and its index in `smallestIndex`.
    * I iterate through the list and, whenever I find a value smaller than `smallest`, I update both `smallest` and `smallestIndex`.
    * I return `smallestIndex`.

* `selectionSorting(arr)`:

    * I create a new empty `ArrayList` called `list` that will hold the sorted result.
    * I save the original `size` before the loop, because the input list shrinks on every iteration.
    * On each iteration I find the index of the smallest remaining element, remove it from `arr`, and add it to the end of `list`:

      `list.add(arr.remove(smallestIndex))`

    * After `size` iterations every element has been moved, in increasing order, into `list`, which I return.

* This works because the smallest remaining element is always the next element that belongs in the sorted output.

* This version builds a **new** list and empties the input list as a side effect, instead of the classic in-place version that swaps elements inside the same array.

* **Time Complexity:** `O(n²)` because for each of the `n` elements I scan the remaining list to find the smallest, and `ArrayList.remove` also shifts elements.

* **Space Complexity:** `O(n)` because the sorted result is stored in a separate list.

* **Important Edge Cases:** empty list (the loop does not run), a one-element list, duplicate values, a list that is already sorted, and the fact that the caller's input list is empty after sorting.
