# DOCUMENTATION OF THE ONE PASS SOLUTIONS

## 1. BEST TIME TO BUY AND SELL STOCK

* The approach I use is a **one-pass running minimum / maximum profit pattern**.

* I store two values:

    * `minSoFar` -> the lowest price seen so far.
    * `maxProfit` -> the best profit found so far.

* I initialize `minSoFar` with `prices[0]` and `maxProfit` with `0`, because if no profitable transaction exists the answer should be `0`.

* I start iterating from index `1` since index `0` is already used to initialize `minSoFar`.

* On every day I first update the cheapest price:

  `minSoFar = Math.min(minSoFar, prices[i])`

* Then I check the profit of selling today after buying at the cheapest price seen so far:

  `maxProfit = Math.max(prices[i] - minSoFar, maxProfit)`

* This works because at every position I already know the **cheapest price before or on the current day**, so I can calculate the best possible profit for selling today without checking every pair of days.

* **Time Complexity:** `O(n)` because I traverse the array once.

* **Space Complexity:** `O(1)` because I only store two variables.

* **Important Edge Cases:** one-element array (profit is `0`), prices that only decrease (profit is `0`), and an empty array (the current code would throw an exception on `prices[0]`).

---

## 2. LENGTH OF LAST WORD

* The approach I use is a **single backward pass** from the end of the string.

* I store two values:

    * `lastChar` -> an index that starts at the last character, `s.length() - 1`.
    * `length` -> the number of letters counted in the last word.

* First, I skip all trailing spaces by moving `lastChar` backward while the current character is `' '`.

* Once `lastChar` lands on a letter, I count characters while:

  `lastChar >= 0 && s.charAt(lastChar) != ' '`

* Every letter increases `length` and moves `lastChar` one step backward.

* The loop stops at the space before the last word (or at the beginning of the string), so `length` holds the length of the last word.

* Reading from the end means I never have to look at the earlier words in the string.

* **Time Complexity:** `O(n)` in the worst case, where `n` is the length of the string, but usually it only touches the trailing spaces and the last word.

* **Space Complexity:** `O(1)`.

* **Important Edge Cases:** trailing spaces, a string with only one word, and a word at the very start of the string. The first loop does not check `lastChar >= 0`, so a string made only of spaces would throw an exception; LeetCode guarantees at least one word, so this does not happen on the judge.
