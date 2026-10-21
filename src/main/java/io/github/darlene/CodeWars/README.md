# DOCUMENTATION OF THE APPROACH USED IN EACH CODEWARS KATA SOLVED

## 1. ARRAY DIFF

* The task is to remove every value from array `a` that appears anywhere in array `b`, while keeping the order of `a`.

### Approach 1: HashSet filter (`arrayDiff`)

* I put every element of `b` into a `HashSet` called `set`, because I only need to know whether a value exists in `b`, and a set lookup is `O(1)` on average.

* I create an `ArrayList` called `list` and iterate through `a`. If a number is **not** in `set`, I add it to `list`.

* Since the method must return an `int[]`, I create `lista` with the size of `list` and copy each value across (Java automatically unboxes each `Integer` to `int`).

* **Time Complexity:** `O(n + m)` where `n` is the length of `a` and `m` is the length of `b`.

* **Space Complexity:** `O(n + m)` for the set and the result list.

### Approach 2: Streams with `removeAll` (`arrayDifference`)

* I convert both arrays into `List<Integer>` using streams, call `listA.removeAll(listB)`, and convert the result back to an `int[]`.

* This is shorter to write, but it is slower: `removeAll` on a `List` checks `listB.contains(...)` for each element, which is `O(n × m)`, and boxing every value into an `Integer` adds memory overhead.

* **Important Edge Cases:** `a` is empty, `b` is empty (return `a` unchanged), `a` contains duplicates of a removed value (all of them must be removed), and no values in common.

---

## 2. HIGHEST AND LOWEST

* The task is to take a string of space-separated numbers and return the highest and lowest values as a string in the format `"highest lowest"`.

### Approach 1: Parse then scan (`highAndLow`)

* I split the string on spaces into `parts` and parse each part into the `int[] arr`.

* I initialize both `lowest` and `highest` with `arr[0]`.

* I iterate through `arr`, updating `lowest` with `Math.min` and `highest` with `Math.max`.

* **Note:** this method returns `lowest + " " + highest`, which is the reverse of the order the kata expects (`"highest lowest"`). `getHighAndLow` returns the correct order.

### Approach 2: Parse and scan in one loop (`getHighAndLow`)

* I split the string into `array` and start with `min = Integer.MAX_VALUE` and `max = Integer.MIN_VALUE`, so that the first number always replaces both.

* In a single loop I parse each value and update `min` and `max` directly, without creating an extra `int[]`.

* I return `String.format("%d %d", max, min)`.

* **Time Complexity:** `O(n)` where `n` is the number of values in the string.

* **Space Complexity:** `O(n)` because `split` creates an array of all the parts.

* **Important Edge Cases:** a single number (highest and lowest are the same), negative numbers, and all numbers being equal.

---

## 3. CREATE PHONE NUMBER

* The task is to take an array of 10 digits and return them formatted as a phone number: `"(123) 456-7890"`.

* The approach I use is a **template replacement**: I start with the template `"(xxx) xxx-xxxx"` and, for each digit in `num`, replace the first remaining `"x"` with that digit.

* **Note:** this does not work yet. Strings in Java are **immutable**, so `number.replaceFirst(...)` returns a new string instead of changing `number`. Because the result is not assigned back, the method returns the unchanged template. The fix is:

  `number = number.replaceFirst("x", Integer.toString(i));`

* **Time Complexity:** `O(n × L)` where `n` is the number of digits and `L` is the length of the template, since each `replaceFirst` scans and copies the string. With a fixed input of 10 digits this is effectively constant.

* **Space Complexity:** `O(L)` because each replacement creates a new string.

* **Important Edge Cases:** an array with fewer or more than 10 digits, and digits that are `0`.
