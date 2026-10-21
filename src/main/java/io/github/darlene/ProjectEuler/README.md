# DOCUMENTATION OF THE APPROACH USED IN EACH PROJECT EULER PROBLEM SOLVED

## 1. MULTIPLES OF 3 AND 5

* The problem asks for the sum of all numbers that are multiples of `3` or `5`.

* The approach I use is a **single pass with the modulo operator**.

* I start with `sum = 0` and iterate through the `nums` array.

* For each number I calculate:

    * `multiple3 = nums[i] % 3`
    * `multiple5 = nums[i] % 5`

* If either remainder is `0`, the number is divisible by `3` or by `5`, so I add it to `sum`.

* I use `||` (or) so that numbers divisible by **both** `3` and `5` (like `15`) are only added once.

* After the loop, I return `sum`.

* **Note:** the original Project Euler problem asks for the sum of the multiples of 3 or 5 **below 1000**. This method takes an array of numbers instead, so to solve the original problem you pass in the numbers `1` to `999`. It could also loop from `1` to `n - 1` directly, or use the arithmetic-series formula for an `O(1)` answer.

* **Time Complexity:** `O(n)` because I check each number once.

* **Space Complexity:** `O(1)` because I only store the running sum.

* **Important Edge Cases:** empty array (returns `0`), numbers divisible by both 3 and 5 (counted once), `0` (divisible by both, adds nothing), negative numbers, and very large sums that could overflow an `int`.
