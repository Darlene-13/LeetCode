# DOCUMENTATION OF THE APPROACH USED IN EACH ARRAY PROBLEM SOLVED

## 1. TWO SUM

* The approach I use is a **one-pass HashMap approach**.

* I create a `HashMap` called `twosum`. The key is the number and the value is its index, because I need to return indexes and not values.

* For every element, I calculate its **complement**:

  `complement = target - arr[i]`

* I look up the complement in the map with `twosum.get(complement)` and store the result in `complementIndex`.

* If `complementIndex` is not `null`, the complement was seen earlier, so I return `{complementIndex, i}`.

* Otherwise, I store the current number and its index with `twosum.put(arr[i], i)` and continue.

* If the loop finishes without finding a pair, I throw an `IllegalArgumentException("No two sum solution")`.

* This works because every number before index `i` is already in the map, so I can check for its pair in constant average time.

* **Time Complexity:** `O(n)` because I go through the array once.

* **Space Complexity:** `O(n)` because the map can hold up to `n` numbers.

* **Important Edge Cases:** no valid pair (throws an exception), duplicate values such as `[3, 3]` with target `6`, and negative numbers.

---

## 2. TWO SUM II (SORTED INPUT)

* Because the array is **sorted**, I use the **two-pointer approach** instead of a HashMap.

* I start with `left = 0` and `right = arr.length - 1`.

* While `left < right`, I calculate `currentSum = arr[left] + arr[right]`.

* If `currentSum == target`, I return `{left + 1, right + 1}`, because the problem uses **1-based** indexes.

* If `currentSum < target`, I need a bigger sum, so I move `left` to the right.

* If `currentSum > target`, I need a smaller sum, so I move `right` to the left.

* This works because the array is sorted: moving `left` can only increase the sum and moving `right` can only decrease it, so no valid pair is skipped.

* **Time Complexity:** `O(n)` because each pointer moves at most `n` times.

* **Space Complexity:** `O(1)` because I only use two pointers.

* **Important Edge Cases:** no valid pair, an array with fewer than two elements, and duplicate values.

* **Note:** the "no pair" return is `new int[]{-1, 1}`, but the problem asks for `{-1, -1}`.

---

## 3. BEST TIME TO BUY AND SELL STOCK

* The approach I use is the **one-pass running minimum** pattern.

* I store two values:

    * `minPriceSoFar` -> the cheapest price seen so far, starting at `prices[0]`.
    * `maxProfit` -> the best profit found so far, starting at `0`.

* For each day, I first update `minPriceSoFar = Math.min(prices[i], minPriceSoFar)`.

* Then I update `maxProfit = Math.max(maxProfit, prices[i] - minPriceSoFar)`, which is the profit if I sell today.

* This works because at every day I already know the cheapest day to buy before (or on) today.

* The loop starts at `i = 0`. That is fine, because on day `0` the profit is `0`.

* **Time Complexity:** `O(n)` because I go through the prices once.

* **Space Complexity:** `O(1)` because I only store two variables.

* **Important Edge Cases:** prices that only decrease (answer `0`), a single price, and an empty array (`prices[0]` would throw).

---

## 4. MAJORITY ELEMENT

* The approach I use is the **Boyer-Moore Voting Algorithm**.

* I store two values: `candidate` (the current guess for the majority element) and `voteCount`.

* In `majorElement`:

    * If `voteCount == 0`, I make the current number the `candidate` and set `voteCount = 1`.
    * If the current number equals `candidate`, I increase `voteCount`.
    * Otherwise, I decrease `voteCount`.

* `majorityElements` is the shorter version of the same idea. If `voteCount == 0`, the current number becomes the `candidate`. Then I add `1` if `num == candidate` and `-1` if it does not.

* This works because the majority element appears more than `n / 2` times. Every other element can cancel at most one of its votes, so it is the one left as `candidate`.

* **Time Complexity:** `O(n)` because I go through the array once.

* **Space Complexity:** `O(1)` because I only store `candidate` and `voteCount`.

* **Important Edge Cases:** a single element, and arrays where the majority element is not at the start. The algorithm assumes a majority element exists.

---

## 5. MERGE SORTED ARRAY

* This problem uses a **three-pointer approach that merges from the back**.

* I use three pointers:

    * `lastNums1 = m - 1` -> the last real element in `nums1`.
    * `lastNums2 = n - 1` -> the last element in `nums2`.
    * `nums1Right = m + n - 1` -> the last position in `nums1`, where the next largest value goes.

* I loop `while (lastNums2 >= 0)`:

    * If `lastNums1 < 0`, `nums1` has no elements left, so I copy `nums2[lastNums2]` into place.
    * If `nums1[lastNums1] > nums2[lastNums2]`, I place the `nums1` value and move `lastNums1` back.
    * Otherwise, I place the `nums2` value and move `lastNums2` back.
    * After every placement, I move `nums1Right` back.

* I merge from the back so that I never overwrite values in `nums1` that I still need.

* I only loop while `nums2` has elements, because once `nums2` is used up, the remaining `nums1` elements are already in the right place.

* **Time Complexity:** `O(m + n)`.

* **Space Complexity:** `O(1)` because the merge happens inside `nums1`.

* **Important Edge Cases:** `n == 0`, `m == 0`, duplicate values, and all of `nums2` being smaller than `nums1`.

---

## 6. MOVE ZEROES

* The approach I use is the **two-pointer (write pointer)** approach.

* `posZero` tracks the leftmost position that should get the next non-zero value.

* I go through the array with `i`. When `nums[i] != 0`:

    * If `i != posZero`, I move the value to `nums[posZero]` and set `nums[i] = 0`.
    * Then I move `posZero` forward.

* The `i != posZero` check avoids overwriting a value with itself (and then zeroing it) when no zeroes have been seen yet.

* This keeps the non-zero values in their original order, because they are written left to right as they are found.

* **Time Complexity:** `O(n)` because I go through the array once.

* **Space Complexity:** `O(1)` because the work is done in place.

* **Important Edge Cases:** an array with no zeroes, an array of only zeroes, and a single element.

---

## 7. PLUS ONE

* I go through `digits` **from the last digit to the first**, the same way I would add by hand.

* If `digits[i] != 9`, I add `1` to it and return `digits` right away, because there is no carry.

* If `digits[i] == 9`, it becomes `0` and the carry moves on to the next digit to the left.

* If the loop finishes, every digit was `9` (for example `999`). I create a new array `result` that is one element longer and set `result[0] = 1`. The rest is already `0` by default, so this gives `1000`.

* **Time Complexity:** `O(n)` in the worst case (all nines). Otherwise it stops at the first non-nine digit.

* **Space Complexity:** `O(1)`, except in the all-nines case, which needs a new array of size `n + 1`.

* **Important Edge Cases:** `[9]`, `[9, 9, 9]`, and a last digit that is not `9`.

---

## 8. REMOVE DUPLICATES FROM SORTED ARRAY

* I wrote two versions.

* `removeDuplicates` (naive): I add every number to a `HashSet` and return `set.size()`.

    * **Time Complexity:** `O(n)`. **Space Complexity:** `O(n)`.
    * **Note:** this only counts the unique values. It does not move them to the front of `nums`, which the problem requires.

* `removeDuplicatesTwoPointer` (better): uses the **two-pointer** approach because the array is sorted.

    * `writeIndex` starts at `1`, because the first element is always unique.
    * For every `i` from `1`, if `nums[i] != nums[i - 1]`, this is a new value, so I write it to `nums[writeIndex]` and move `writeIndex` forward.
    * I return `writeIndex`, which is the number of unique values.
    * This works because the array is sorted, so duplicates are always next to each other.

* **Time Complexity:** `O(n)` because I go through the array once.

* **Space Complexity:** `O(1)` because it works in place.

* **Important Edge Cases:** an empty array (the two-pointer version returns `1` instead of `0`), one element, and all elements equal.

---

## 9. TOP K FREQUENT ELEMENTS

* First I build a frequency `map` with `map.put(num, map.getOrDefault(num, 0) + 1)`, where the key is the number and the value is how often it appears.

* `topKFrequent` uses a **min-heap of size k**:

    * The `PriorityQueue` compares numbers by their frequency: `(a, b) -> map.get(a) - map.get(b)`.
    * I add every unique number. Whenever the heap grows past `k`, I `poll()` the least frequent one.
    * At the end, the heap holds the `k` most frequent numbers, and I poll them into `result`.
    * **Time Complexity:** `O(n log k)`. **Space Complexity:** `O(n)` for the map plus `O(k)` for the heap.

* `topKFrequent1` uses **bucket sort**:

    * `buckets` is an array of lists where the index is the frequency.
    * I put each number into `buckets[freq]`.
    * I go from the highest frequency down to `1` and collect numbers until `index == k`.
    * **Time Complexity:** `O(n)`. **Space Complexity:** `O(n)`.
    * **Note:** `buckets` is created with size `nums.length - 1`, but a frequency can be as high as `nums.length`. For example, with `[1, 1]` the frequency is `2` and `buckets[2]` is out of bounds. It should be `new List[nums.length + 1]`.

* **Important Edge Cases:** `k` equal to the number of unique values, all elements the same, and ties in frequency.

---

## 10. TOP K FREQUENT WORDS

* First I count each word with a `HashMap` called `map`.

* I use a **min-heap of size k**, with a comparator that:

    * compares by frequency first (`map.get(a) - map.get(b)`), so the least frequent word is at the top, and
    * on equal frequency uses `b.compareTo(a)`, so the word that comes **later alphabetically** is at the top and gets removed first.

* I add every word and `poll()` whenever the heap size goes past `k`.

* I then poll everything into `result`. This gives the words from least to most important, so I call `Collections.reverse(result)` to get the highest frequency first and alphabetical order for ties.

* **Time Complexity:** `O(n log k)`.

* **Space Complexity:** `O(n)` for the map plus `O(k)` for the heap.

* **Important Edge Cases:** words with the same frequency (they must be in alphabetical order), and `k` equal to the number of unique words.

---

## 11. MEDIAN OF TWO SORTED ARRAYS

* I wrote two versions.

* `findMedian` (simple):

    * I join the arrays with `IntStream.concat` and sort the result into `sortedArr`.
    * If the length is odd, the median is the middle element `sortedArr[length / 2]`.
    * If the length is even, the median is the average of `sortedArr[length / 2]` and `sortedArr[length / 2 - 1]`, which I store as `double`s to avoid integer division.
    * **Time Complexity:** `O((m + n) log(m + n))` because of sorting. **Space Complexity:** `O(m + n)`.

* `findMedianSortedArrays` (better, **binary search on the partition**):

    * I make sure `nums1` is the smaller array by swapping the arguments if needed, so I binary search the shorter one.
    * `leftSize = (m + n + 1) / 2` is how many elements must be on the left half.
    * I binary search `partition1` between `low = 0` and `high = m`, and set `partition2 = leftSize - partition1`.
    * Around each cut, I take the boundary values `L1`, `R1` (from `nums1`) and `L2`, `R2` (from `nums2`). I use `Integer.MIN_VALUE` / `Integer.MAX_VALUE` when a cut is at the edge of an array.
    * If `L1 > R2`, I took too many from `nums1`, so `high = partition1 - 1`.
    * If `L2 > R1`, I took too few from `nums1`, so `low = partition1 + 1`.
    * Otherwise the partition is correct. If the total length is odd, the median is `Math.max(L1, L2)`. If it is even, it is `(Math.max(L1, L2) + Math.min(R1, R2)) / 2.0`.
    * **Time Complexity:** `O(log(min(m, n)))`. **Space Complexity:** `O(1)`.

* **Important Edge Cases:** one array empty, arrays of very different lengths, an odd versus even total length, and all of one array being smaller than the other.

---

## 12. ROTATE ARRAY / REVERSE ARRAY (IN PROGRESS)

* `ReverseArray.rotate` is not finished yet. It only stores `n = nums.length`.

* The commented-out `reverseArray` uses the **two-pointer swap**: swap `arr[left]` and `arr[right]`, then move the pointers toward each other. It runs in `O(n)` time and `O(1)` space.

* **Note:** the commented code does `right++` where it should do `right--`, so `right` would move out of bounds.

---

## 13. THREE SUM (IN PROGRESS)

* `ThreeSum.java` only has a commented-out method signature so far.
