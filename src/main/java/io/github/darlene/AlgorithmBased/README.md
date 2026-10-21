# ALGORITHM BASED PRACTICE

This folder groups problems by the **algorithmic pattern** used to solve them instead of by data structure. Each subfolder focuses on one pattern and has its own README that documents the approach used in each solution.

---

## 1. [BINARY SEARCH](BinarySearch/README.md)

* Binary search works on **sorted** input by repeatedly cutting the search range in half.
* I keep a `low` and a `high` boundary, calculate `mid = low + (high - low) / 2`, and move one of the boundaries depending on whether the middle value is too large or too small.
* It reduces the search from `O(n)` to `O(log n)`.

---

## 2. [ONE PASS SOLUTIONS](OnePassSolutions/README.md)

* These problems are solved by walking through the input **only once** while keeping track of a few running values (for example a running minimum or a counter).
* They usually run in `O(n)` time and `O(1)` extra space.

---

## 3. [SELECTION SORT](SelectionSort/README.md)

* Selection sort repeatedly finds the **smallest remaining element** and moves it into the sorted output.
* It is simple to understand but takes `O(n²)` time.

---

## 4. [SLIDING WINDOW](SlidingWindow/README.md)

* A sliding window keeps track of a **contiguous range** of the input using a left and a right boundary.
* The right side grows the window and the left side shrinks it whenever the window stops being valid, so each element enters and leaves the window at most once.
* This turns many `O(n²)` "check every subarray / substring" problems into `O(n)` problems.

---

## 5. [TWO POINTER](TwoPointer/README.md)

* The two-pointer pattern uses two indexes that move through the input, often starting at **opposite ends** and moving toward each other.
* It is useful for comparing pairs of elements (palindromes, pair sums on sorted arrays) without nested loops, giving `O(n)` time and `O(1)` extra space.
