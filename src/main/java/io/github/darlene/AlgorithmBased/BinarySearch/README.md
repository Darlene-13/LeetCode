# DOCUMENTATION OF THE BINARY SEARCH PROBLEMS

## 1. BINARY SEARCH INTRO

* The approach I use is the classic **iterative binary search** on a sorted array.

* I define two boundaries:

    * `low` -> starts at index `0`.
    * `high` -> starts at the last index, `arr.length - 1`.

* I continue while:

  `low <= high`

* On every iteration I calculate the middle index:

  `mid = low + ((high - low) / 2)`

* I use `low + (high - low) / 2` instead of `(low + high) / 2` so that adding two large indexes can never overflow an `int`.

* If `arr[mid] == item`, I have found the item, so I print it and return `mid`.

* If `arr[mid] > item`, the item can only be on the left side, so I move `high` to `mid - 1`.

* Otherwise the item can only be on the right side, so I move `low` to `mid + 1`.

* If the loop ends without finding the item, I return `-1`.

* **Time Complexity:** `O(log n)` because the search range is cut in half on every iteration.

* **Space Complexity:** `O(1)` because I only store a few index variables.

* **Important Edge Cases:** empty array, the item being the first or last element, the item not existing in the array, and an unsorted array (binary search does not work on unsorted input).

---

## 2. SQRT(X) — FIND THE SQUARE ROOT

* The approach I use is **binary search on the answer**. Instead of searching inside an array, I search the range of numbers from `0` to `x` for the largest number whose square is less than or equal to `x`.

* I store `low`, `high`, `mid` and `val` as `long` because `mid * mid` can overflow an `int` when `x` is large.

* I start with:

    * `low = 0`
    * `high = x`

* On every iteration I calculate `mid` and its square:

  `val = mid * mid`

* If `val == x`, `mid` is the exact square root, so I return it.

* If `val > x`, `mid` is too big, so I move `high` to `mid - 1`.

* Otherwise `mid` is too small, so I move `low` to `mid + 1`.

* When the loop ends, `low` has moved one step past the largest number whose square fits inside `x`, so I return `low - 1` (the square root rounded down).

* **Time Complexity:** `O(log x)` because the range `0..x` is halved on every iteration.

* **Space Complexity:** `O(1)`.

* **Important Edge Cases:** `x = 0`, `x = 1`, perfect squares, non-perfect squares (the answer must be rounded down), and very large values like `Integer.MAX_VALUE` (handled by using `long`).

---

## 3. SEARCH INSERT POSITION

* The approach I use is a **binary search that returns the insertion point** when the target is not found.

* `seachInsert` is the working solution:

    * I set `low = 0` and `high = nums.length - 1`.
    * I calculate `mid` and compare `nums[mid]` with `target`.
    * If they are equal, I return `mid`.
    * If `nums[mid] > target`, I move `high` to `mid - 1`.
    * Otherwise I move `low` to `mid + 1`.

* If the loop ends without finding the target, I return `low`. This works because the loop only stops when `low` passes `high`, and at that moment `low` is the first index whose value is greater than `target`, which is exactly where the target would be inserted to keep the array sorted.

* **Note:** the first method, `search`, is an earlier attempt and is not correct. It compares the **index** `mid` with `target` instead of the value `nums[mid]`, and it returns `low + (high - low)`, which is just `high`. Use `seachInsert` instead.

* **Time Complexity:** `O(log n)` because the search range is halved every iteration.

* **Space Complexity:** `O(1)`.

* **Important Edge Cases:** empty array (returns `0`), target smaller than every element (returns `0`), target larger than every element (returns `nums.length`), and target already present in the array.
