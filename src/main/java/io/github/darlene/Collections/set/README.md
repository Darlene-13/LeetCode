# DOCUMENTATION OF THE APPROACH USED IN EACH SET PROBLEM SOLVED

A `HashSet` stores **unique** values and has `O(1)` average time for `add` and `contains`.

## 1. LONGEST CONSECUTIVE SEQUENCE

* (The file is named `LongestConsecutiveSentence.java`, but the problem is Longest Consecutive **Sequence**.)

* The approach I use is a **HashSet with sequence-start detection**.

* First I add every number from `nums` into a `HashSet` called `set`. This also removes duplicates.

* `longest` stores the length of the longest sequence found so far.

* I go through each `num` in the `set`:

    * I only start counting if `!set.contains(num - 1)`. If `num - 1` exists, `num` is not the start of a sequence and will be counted from an earlier number.
    * From a start, I set `current = num` and `length = 1`.
    * While `set.contains(current + 1)`, I move `current` forward and increase `length`.
    * I update `longest = Math.max(longest, length)`.

* This works because each sequence is counted only once, from its smallest number. That way I avoid sorting and avoid counting the same sequence again from every number in it.

* **Time Complexity:** `O(n)` on average. Each number is added once, and the inner `while` loop only runs from sequence starts, so each number is visited a constant number of times overall.

* **Space Complexity:** `O(n)` for the set.

* **Important Edge Cases:** an empty array (returns `0`), duplicate values, negative numbers, and numbers that are all separate (returns `1`).
