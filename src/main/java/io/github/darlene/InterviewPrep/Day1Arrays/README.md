# DOCUMENTATION OF THE APPROACH USED IN EACH LEETCODE PROBLEM SOLVED

## 1. TWO SUM

* The approach I use for this problem is a **one-pass HashMap approach**. Instead of checking every possible pair, I iterate through the array once.

* For each element, I need to know both its **value and index**, so I use a `HashMap` where the key is the number and the value is its index.

* As I iterate through the array, I calculate the **complement** of the current number:

  `complement = target - currentNumber`

* The complement is the number I need to find in order for the current number and the complement to add up to the target.

* I first check whether the complement already exists in the HashMap.

* If it exists, I retrieve its index and return the two indexes: the complement's index and the current index.

* If the complement does not exist, I store the current number and its index in the HashMap and continue iterating.

* This works because when we reach a number, all previously visited numbers are already stored and can be checked in constant average time.

* **Time Complexity:** `O(n)` because we iterate through the array once.

* **Space Complexity:** `O(n)` because the HashMap can store up to `n` elements.

* **Important Edge Cases:** empty input, an input with only one element, and cases where no valid pair exists.

---

## 2. BEST TIME TO BUY AND SELL STOCK

* The approach I use is a **one-pass running minimum / maximum profit pattern**.

* I store two things:

    * `minPrice` → the lowest price seen so far.
    * `maxProfit` → the maximum profit found so far.

* I initialize `minPrice` with `prices[0]` because I need an initial price to compare against.

* I initialize `maxProfit` to `0` because if no profitable transaction exists, the answer should be `0`.

* I start iterating from index `1` because index `0` is already being used to initialize `minPrice`.

* During each iteration, I compare the current price with `minPrice` and update the minimum price if the current price is lower.

* I then calculate the potential profit by subtracting the minimum price from the current price:

  `currentProfit = currentPrice - minPrice`

* I update `maxProfit` by keeping the larger value between the current maximum profit and the current profit.

* This works because at every position I know the **cheapest price seen before the current day**, allowing me to calculate the best possible profit for selling today.

* **Time Complexity:** `O(n)` because I traverse the array once.

* **Space Complexity:** `O(1)` because I only store a few variables regardless of the input size.

* **Important Edge Cases:** empty array, one-element array, and an array where prices continuously decrease.

---

## 3. CONTAINS DUPLICATE

* The approach I use is a **one-pass HashSet approach**.
* I create a `HashSet` because I only need to keep track of the values I have already seen, and a Set does not allow duplicate values.
* As I iterate through the array, I first check whether the current number already exists in the Set.
* If it does, then I have encountered the same number before, so I immediately return `true`.
* If it does not exist, I add the current number to the Set and continue to the next element.
* If I finish iterating without finding a number that already exists in the Set, I return `false`.
* **Time Complexity:** `O(n)` on average because each element is processed once and HashSet lookup is `O(1)` on average.
* **Space Complexity:** `O(n)` because the Set can store up to `n` unique values.
* **Important Edge Cases:** empty array, one-element array, and an array containing duplicates at the beginning, middle, or end.

---

## 4. MERGE SORTED ARRAY

* This problem uses a **three-pointer approach**.

* We have two sorted arrays, but `nums1` already contains enough empty space to hold the final merged result.

* Instead of merging from the beginning, I merge **from the back** so that I do not overwrite the unprocessed elements already inside `nums1`.

* I use three pointers:

    * `lastNums1` → points to the last actual element in `nums1`.
    * `lastNums2` → points to the last element in `nums2`.
    * `lastNumsMerged` → points to the last available position in `nums1`.

* I continue while `nums2` still has elements:

  `while (lastNums2 >= 0)`

* At every step, I compare the values pointed to by `lastNums1` and `lastNums2`.

* The larger value is placed at `lastNumsMerged` because we are filling the merged array from the largest value toward the smallest.

* If `nums1` has no remaining elements, I simply place the remaining elements from `nums2` into `nums1`.

* If the value from `nums2` is larger, I place it at the merged position and move the `nums2` pointer.

* Otherwise, I place the value from `nums1` at the merged position and move the `nums1` pointer.

* The merged pointer moves after every placement.

* We only need to continue while `nums2` has elements because if `nums2` is completely consumed, the remaining elements in `nums1` are already in their correct positions.

* **Time Complexity:** `O(m + n)` because every element from both arrays is considered at most once.

* **Space Complexity:** `O(1)` because the merge happens directly inside `nums1` without creating another array.

* **Important Edge Cases:** `nums2` is empty, `nums1` has no initial elements, duplicate values, and all elements in one array are smaller/larger than the other.

---

## 5. VALID PALINDROME

* A palindrome is a string that reads the same forwards and backwards.

* I use the **two-pointer approach** because I need to compare characters from opposite ends of the string.

* First, I convert the string to lowercase so that uppercase and lowercase versions of the same letter are treated as equal.

* I create two pointers:

    * `leftPointer` starts at the beginning of the string.
    * `rightPointer` starts at the end of the string.

* I continue while:

  `leftPointer < rightPointer`

* Before comparing characters, I skip any characters that are not letters or digits.

* The left pointer moves forward until it reaches a valid alphanumeric character.

* The right pointer moves backward until it reaches a valid alphanumeric character.

* Once both pointers are positioned on valid characters, I compare them.

* If the characters are different, the string cannot be a palindrome, so I return `false`.

* If they are equal, I move both pointers inward and continue.

* If the pointers meet or cross without finding a mismatch, all necessary character pairs have matched, so I return `true`.

* **Time Complexity:** `O(n)` because each character is visited at most a constant number of times.

* **Space Complexity:** `O(n)` in the current implementation because I create a lowercase version of the string. The two-pointer algorithm itself uses `O(1)` auxiliary pointer space.

* **Important Edge Cases:** empty string, one-character string, strings containing only non-alphanumeric characters, spaces/punctuation, and mixed uppercase/lowercase characters.


