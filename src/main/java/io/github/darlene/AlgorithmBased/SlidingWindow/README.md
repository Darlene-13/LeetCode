# DOCUMENTATION OF THE SLIDING WINDOW PROBLEMS

## 1. LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS

### Approach 1: HashSet sliding window (`lengthOfTheLongestSubstring`)

* The approach I use is a **variable-size sliding window** backed by a `HashSet`.

* The window is the range from `leftPointer` to `i`, and the `HashSet` holds every character currently inside the window.

* I iterate through the string with `i` as the right side of the window.

* Before adding `s.charAt(i)`, I check whether it is already in the set. While it is, I shrink the window from the left by removing `s.charAt(leftPointer)` from the set and moving `leftPointer` forward.

* Once the duplicate is gone, I add the current character to the set.

* I calculate the current window length:

  `length = i - leftPointer + 1`

* I keep the best answer in `maxLength = Math.max(maxLength, length)`.

* This works because the window always contains only unique characters, and every character is added and removed at most once.

* **Time Complexity:** `O(n)` because both `i` and `leftPointer` move forward at most `n` times.

* **Space Complexity:** `O(k)` where `k` is the number of distinct characters, since that is the most the set can hold.

### Approach 2: Last-seen array (`lengthOfLongestSubString`, optimal)

* Instead of shrinking the window one character at a time, I **jump** `leftPointer` directly past the previous occurrence of the repeated character.

* I use an `int[128]` array called `lastSeen`, indexed by the ASCII value of each character. It stores `index + 1` of the last time that character appeared (so the default `0` means "never seen").

* For each `right` index:

    * I move the left side forward if needed:

      `leftPointer = Math.max(leftPointer, lastSeen[s.charAt(right)])`

    * I use `Math.max` so that `leftPointer` never moves backward to an old occurrence that is already outside the window.

    * I update `maxLength = Math.max(maxLength, right - leftPointer + 1)`.

    * I record the current position: `lastSeen[s.charAt(right)] = right + 1`.

* **Time Complexity:** `O(n)` with a single pass and no inner loop.

* **Space Complexity:** `O(1)` because the array always has 128 slots.

* **Important Edge Cases:** empty string (returns `0`), a string where every character is the same, a string with all unique characters, and repeated characters that are already outside the current window (for example `"abba"`). The array approach assumes ASCII characters; characters above code 127 would go out of bounds.

---

## 2. MAXIMUM SUM OF SUBARRAY OF SIZE K

* **Note:** this solution is not implemented yet. `maxSum` is an empty method that always returns `0`.

* The planned approach is a **fixed-size sliding window**:

    * Add up the first `k` elements to get the first window sum.
    * Slide the window one step at a time by adding the new element on the right and subtracting the element that leaves on the left.
    * Keep track of the largest window sum seen.

* **Time Complexity (planned):** `O(n)` because each element is added once and removed once.

* **Space Complexity (planned):** `O(1)`.

* **Important Edge Cases:** `k` larger than the array length, `k = 0`, arrays with negative numbers, and `k` equal to the array length.
