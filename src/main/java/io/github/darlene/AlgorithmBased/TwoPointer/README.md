# DOCUMENTATION OF THE TWO POINTER PROBLEMS

## 1. VALID PALINDROME

* A palindrome is a string that reads the same forwards and backwards once non-alphanumeric characters are ignored and letter case is ignored.

* I use the **two-pointer approach** because I need to compare characters from opposite ends of the string.

* First, I convert the string to lowercase so that `'A'` and `'a'` are treated as equal.

* I create two pointers:

    * `left` starts at the beginning of the string.
    * `right` starts at the end of the string.

* I continue while:

  `left < right`

* Before comparing, I skip invalid characters:

    * `left` moves forward while it is inside the string and not on a letter or digit.
    * `right` moves backward while it is inside the string and not on a letter or digit.

* If skipping makes the pointers meet or cross (`left >= right`), there is nothing left to compare, so I break out of the loop.

* If `s.charAt(left) != s.charAt(right)`, the string cannot be a palindrome, so I return `false`.

* Otherwise I move both pointers inward and continue.

* If the loop finishes without a mismatch, every pair matched, so I return `true`.

* **Time Complexity:** `O(n)` because each character is visited at most a constant number of times.

* **Space Complexity:** `O(n)` in this implementation because `toLowerCase()` creates a new string. The two-pointer logic itself only uses `O(1)` extra space.

* **Important Edge Cases:** empty string, one-character string, strings containing only spaces or punctuation (returns `true`), and mixed uppercase/lowercase characters.
