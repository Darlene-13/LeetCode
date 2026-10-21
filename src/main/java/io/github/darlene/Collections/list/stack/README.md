# DOCUMENTATION OF THE APPROACH USED IN EACH STACK PROBLEM SOLVED

A stack is a **LIFO (Last In, First Out)** data structure. The last element pushed is the first element popped. All of these solutions use `java.util.Stack`.

## 1. VALID PARENTHESES

* The approach I use is a **stack for matching brackets**.

* I create a `Stack<Character>` to hold the opening brackets that have not been closed yet.

* For each character `current` in the string:

    * If it is an opening bracket (`{`, `[`, `(`), I push it onto the stack.
    * If it is a closing bracket (`}`, `]`, `)`):
        * If the stack is empty, there is nothing to close, so I return `false`.
        * If `stack.peek()` is not the matching opening bracket, the brackets are in the wrong order, so I return `false`.
        * Otherwise, it matches, so I `pop()` the opening bracket.

* At the end, I return `stack.isEmpty()`. If anything is left on the stack, some brackets were never closed.

* This works because the most recently opened bracket must be the first one closed, which is exactly LIFO order.

* **Time Complexity:** `O(n)` because I go through the string once.

* **Space Complexity:** `O(n)` because in the worst case every character is an opening bracket.

* **Important Edge Cases:** an empty string (`true`), a string that starts with a closing bracket, only opening brackets (for example `"(("`), and wrong nesting (for example `"(]"` or `"([)]"`).

---

## 2. MIN STACK

* The goal is to support `push`, `pop`, `top` and `getMin` in `O(1)` time.

* I use **two stacks**:

    * `values` -> stores every pushed value.
    * `min` -> stores the minimum value **at each level** of the stack.

* `push(value)`:

    * I push `value` onto `values`.
    * If `min` is empty, I push `value` onto `min`.
    * Otherwise, I push `Math.min(value, min.peek())`, which is the minimum including the new value.

* `pop()` pops from **both** stacks, so they always have the same size.

* `top()` returns `values.peek()`, and `getMin()` returns `min.peek()`.

* This works because `min` stores the minimum for every level of the stack. After a pop, the previous minimum is already on top of `min`, so I never need to search for it.

* **Time Complexity:** `O(1)` for every operation.

* **Space Complexity:** `O(n)`, because `min` has the same number of elements as `values`.

* **Important Edge Cases:** pushing duplicate minimum values, popping the current minimum, and negative numbers. Calling `pop`, `top` or `getMin` on an empty stack throws an `EmptyStackException`.

---

## 3. DAILY TEMPERATURES

* The approach I use is a **monotonic decreasing stack** of indexes.

* I use a stack instead of checking every future day for every day, which would be `O(n²)`.

* I store:

    * `answer` -> an array where `answer[i]` is how many days I wait for a warmer temperature. It starts as `0`.
    * `stack` -> the **indexes** of days that have not found a warmer day yet.

* For each day `i`:

    * While the stack is not empty and `temps[i] > temps[stack.peek()]`, today is the warmer day for that earlier index. I `pop()` it into `previous` and set `answer[previous] = i - previous`.
    * Then I push `i`, because today still needs a warmer day of its own.

* The temperatures for the indexes in the stack are always in decreasing order from bottom to top. That is why a single warmer day can resolve several waiting days at once.

* Any index still in the stack at the end has no warmer day, so its answer stays `0`.

* `findTemps` is a second practice copy of the same algorithm.

* **Time Complexity:** `O(n)`, because each index is pushed once and popped at most once.

* **Space Complexity:** `O(n)` for the stack and `answer`.

* **Important Edge Cases:** temperatures that only decrease (all `0`s), temperatures that only increase, equal temperatures (equal is not warmer), and a single day.
