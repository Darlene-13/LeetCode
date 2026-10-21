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

    * `minPrice` -> the lowest price seen so far.
    * `maxProfit` -> the maximum profit found so far.

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

    * `lastNums1` -> points to the last actual element in `nums1`.
    * `lastNums2` -> points to the last element in `nums2`.
    * `lastNumsMerged` -> points to the last available position in `nums1`.

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

---

## 6. MAXIMUM SUBARRAY

* The approach I use is **Kadane's Algorithm**, a one-pass dynamic programming pattern.

* I store two things:

    * `currentSum` -> the best sum of a subarray that ends at the current index.
    * `maxSum` -> the best subarray sum found anywhere so far.

* I initialize both with `nums[0]` instead of `0`, so that an array of only negative numbers returns its largest negative value instead of `0`.

* I start iterating from index `1` because index `0` is already used for initialization.

* At every index I decide whether to **extend** the previous subarray or **start a new one** at the current element:

  `currentSum = Math.max(nums[i], currentSum + nums[i])`

* If `currentSum + nums[i]` is smaller than `nums[i]` on its own, the previous subarray is only dragging the sum down, so I drop it and start fresh from `nums[i]`.

* After updating `currentSum`, I update `maxSum` by keeping the larger of the two.

* This works because the best subarray must end at some index, and `currentSum` always holds the best sum ending exactly at the index I am on.

* **Time Complexity:** `O(n)` because I traverse the array once.

* **Space Complexity:** `O(1)` because I only store two variables.

* **Important Edge Cases:** one-element array, all negative numbers, all positive numbers (the answer is the whole array), and zeros mixed in. An empty array would throw on `nums[0]`, but LeetCode guarantees at least one element.

---

## 7. CONTAINER WITH MOST WATER

* The approach I use is the **two-pointer approach** with pointers starting at opposite ends.

* I create:

    * `left` -> starts at index `0`.
    * `right` -> starts at index `height.length - 1`.
    * `maxArea` -> the largest area found so far, starting at `0`.

* The water a container can hold is limited by its **shorter** wall, so at each step I calculate:

  `currHeight = Math.min(height[left], height[right])`

  `width = right - left`

  `area = currHeight * width`

* I update `maxArea` with the larger value between the current area and the previous maximum.

* I then move the pointer that points to the **shorter** wall inward:

    * If `height[left] < height[right]`, I move `left` forward.
    * Otherwise, I move `right` backward.

* I move the shorter wall because moving the taller one can never give a bigger area. The width shrinks, and the height is still capped by the same shorter wall. Moving the shorter wall is the only move that might find a taller one.

* I loop with a `for` loop that runs `height.length` times. After `n - 1` moves the pointers meet, so the last iteration computes a width of `0` (area `0`), which never changes `maxArea`. The result is correct, but `while (left < right)` would express the stopping condition more directly and skip that extra iteration.

* **Time Complexity:** `O(n)` because each pointer moves inward at most `n` times in total.

* **Space Complexity:** `O(1)` because I only use a few variables.

* **Important Edge Cases:** two walls only, all walls the same height, walls in increasing or decreasing order, and walls of height `0`.

---

## 8. PRODUCT OF ARRAY EXCEPT SELF

* The approach I use is a **prefix and suffix product** approach done in two passes, without division.

* The answer for each index is:

  `product of everything to the left * product of everything to the right`

* I create a `result` array and a running `product` variable starting at `1`.

* **First pass (left to right):**

    * Before multiplying in `nums[i]`, I store the current `product` in `result[i]`. At that moment `product` holds the product of all elements **to the left** of `i`.
    * Then I update `product = product * nums[i]` so it is ready for the next index.

* I then reset `product` back to `1`.

* **Second pass (right to left)**, starting from `rightPointer = nums.length - 1`:

    * I multiply `result[i]` by the current `product`, which now holds the product of all elements **to the right** of `i`.
    * Then I update `product = product * nums[i]`.

* After both passes, each `result[i]` holds the left product times the right product, which is the product of every element except `nums[i]`.

* I avoid division because the problem does not allow it, and because division would break when the array contains `0`.

* **Time Complexity:** `O(n)` because I make two passes over the array.

* **Space Complexity:** `O(1)` extra space, not counting the `result` array that is returned. I only use the `product` variable.

* **Important Edge Cases:** one zero in the array (only that index gets a non-zero product), two or more zeros (every result is `0`), negative numbers, and a two-element array.

---

## 9. MOVE ZEROES

* The approach I use is a **two-pointer write/read approach** that works in place.

* I use:

    * `i` -> the read pointer that scans every element.
    * `insert` -> the write pointer, the next position where a non-zero value should go.

* **First pass:** whenever `nums[i]` is not `0`, I copy it to `nums[insert]` and move `insert` forward. This packs all non-zero values at the front while keeping their original order.

* **Second pass:** once every non-zero value is in place, every position from `insert` to the end of the array should be `0`, so I fill them with zeros in a `while (insert < nums.length)` loop.

* This keeps the relative order of the non-zero elements because I copy them in the same order I read them.

* **Time Complexity:** `O(n)` because the read pass and the fill pass each cover the array at most once.

* **Space Complexity:** `O(1)` because I modify the array in place.

* **Important Edge Cases:** array with no zeros, array of only zeros, zeros already at the end, one-element array, and an empty array.

---

## 10. MAJORITY ELEMENT

* The approach I use is the **Boyer-Moore Voting Algorithm**.

* The majority element appears **more than `n / 2` times**, so it outnumbers all the other elements combined.

* I store two things:

    * `candidate` -> the element I currently think is the majority, starting with `nums[0]`.
    * `count` -> how far ahead the candidate is, starting at `1`.

* I iterate from index `1`:

    * If `nums[i] == candidate`, I increase `count` (a vote for the candidate).
    * Otherwise, I decrease `count` (a vote against it, which cancels one occurrence).

* If `count` drops to `0`, the candidate has been fully cancelled out, so I make `nums[i]` the new `candidate` and set `count` to `1`.

* This works because every non-majority element can cancel at most one occurrence of the majority element. Since the majority element appears more than all others combined, it is the one left standing at the end.

* I return `candidate` without a second verification pass. That is safe here because the problem guarantees a majority element exists. Without that guarantee I would need to count `candidate` again to confirm it.

* **Time Complexity:** `O(n)` because I traverse the array once.

* **Space Complexity:** `O(1)` because I only store `candidate` and `count`.

* **Important Edge Cases:** one-element array, the majority element appearing at the end, all elements the same, and alternating values with the majority still winning.
