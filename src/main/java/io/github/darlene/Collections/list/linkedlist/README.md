# DOCUMENTATION OF THE APPROACH USED IN EACH LINKED LIST PROBLEM SOLVED

## SUPPORTING CLASSES

* **`ListNode`** -> the basic node used by every problem in this folder. It stores an `int val` and a `ListNode next` pointer, and has three constructors: empty, value only, and value plus next.

    * **Bug:** the `ListNode(int val, ListNode next)` constructor sets `this.next = null` instead of `this.next = next`, so the `next` argument is ignored. It should be `this.next = next;`.

* **`LinkedListOperations`** -> my own small linked list built on a **dummy (sentinel) node** (`dummy = new ListNode(-1)`) plus a `size` counter.

    * `insertAtHead(val)` -> the new node points to `dummy.next` (the real first node), then `dummy.next` becomes the new node. `O(1)`.
    * `insertAtTail(val)` -> I walk `curr` from the dummy until `curr.next == null` (the last node), then attach the new node. `O(n)`.
    * `delete(val)` -> I walk until `curr.next` holds the value, then skip over it with `curr.next = curr.next.next`. The dummy means deleting the first node needs no special case.
    * `traverseLinkedList()` -> starts from `dummy.next` (never the dummy itself) and prints `1->2->3->null` using a `StringBuilder`.

* **`TraverseLinkedList`** -> `printList(head)` walks the list with a `current` pointer and prints each value followed by `->`.

* **`LinkedList`** -> holds `reverseLinkedList(head)`, the same three-pointer reversal documented in **Reverse Linked List** below.

* **`FindLength`** -> walks the list with `current`, incrementing `count` for every node. `O(n)` time, `O(1)` space.

* **`FindMaximum`** -> starts `currentMax` at `head.val` and keeps `Math.max(currentMax, current.val)` while walking the list. Returns `0` for an empty list, which can't be told apart from a list whose maximum really is `0`.

---

## 1. REVERSE LINKED LIST

* The approach I use is the **three-pointer iterative reversal** (`ReverseList`, and also `LinkedList.reverseLinkedList`).

* I use three pointers:

    * `curr` -> the node I am currently reversing, starting at `head`.
    * `prev` -> the node that `curr` should now point back to, starting at `null` because the old head becomes the new tail.
    * `next` -> a temporary save of `curr.next` so I don't lose the rest of the list.

* On each iteration I:

    1. Save `next = curr.next`.
    2. Flip the pointer: `curr.next = prev`.
    3. Move `prev` forward to `curr`.
    4. Move `curr` forward to `next`.

* When `curr` becomes `null`, `prev` is sitting on the old last node, which is the new head, so I return `prev`.

* **Time Complexity:** `O(n)` because every node is visited once.

* **Space Complexity:** `O(1)` because I only reassign pointers.

* **Important Edge Cases:** empty list (returns `null`), single node, two nodes.

---

## 2. MIDDLE OF THE LINKED LIST

* I solved this two ways in `MiddleNode`.

* **Option 1 – Two traversals (`middleNode1`):**

    * The first pass counts the nodes into `count`.
    * I compute `middle = count / 2`.
    * The second pass walks `current` forward `middle` times and returns it.
    * For an even length this returns the **second** middle, which is what LeetCode expects.

* **Option 2 – Fast and slow pointers (`middleNode`):**

    * `slow` moves one step and `fast` moves two steps while `fast != null && fast.next != null`.
    * When `fast` reaches the end, `slow` has covered half the distance, so `slow` is the middle.
    * This also returns the second middle for even lengths, and it needs only one pass.

* **Time Complexity:** `O(n)` for both, but option 2 makes a single pass.

* **Space Complexity:** `O(1)` for both.

* **Important Edge Cases:** single node, two nodes (returns the second), odd vs even length.

---

## 3. LINKED LIST CYCLE

* The approach I use is **Floyd's fast and slow pointers (tortoise and hare)** in `HasCycle`.

* Both `slow` and `fast` start at `head`.

* While `fast != null && fast.next != null`, `slow` moves one step and `fast` moves two.

* If there is a cycle, `fast` eventually laps `slow` inside the loop and they land on the **same node** (`slow == fast`), so I return `true`.

* If `fast` reaches `null`, the list has an end, so there is no cycle and I return `false`.

* I compare the node references, not their values, because two different nodes can hold the same value.

* **Time Complexity:** `O(n)`.

* **Space Complexity:** `O(1)`, compared with `O(n)` for a HashSet of visited nodes.

* **Important Edge Cases:** empty list, single node with no cycle, single node pointing to itself, cycle back to the head.

---

## 4. PALINDROME LINKED LIST

* I solved this twice (`IsPalindrome` and `PalindromeLinkedList`). Both use the same three-step pattern:

    1. **Find the middle** with fast and slow pointers.
    2. **Reverse the second half** starting from `slow`, using the three-pointer reversal.
    3. **Compare** the two halves with `first` (starting at `head`) and `second` (starting at the reversed half `previous` / `prev`), moving both forward. Any mismatch returns `false`.

* The comparison loop stops as soon as either pointer is `null`, so it only checks as many pairs as the shorter half has.

* **The difference between the two versions is the middle-finding loop:**

    * `IsPalindrome` uses `while (fast != null && fast.next != null)`, so `slow` lands on the **second** middle for even lengths. It safely handles an empty list.
    * `PalindromeLinkedList` uses `while (fast.next != null && fast.next.next != null)`, so `slow` lands on the **first** middle. **Bug:** it throws a `NullPointerException` when `head` is `null`, because it reads `fast.next` without checking `fast` first. `IsPalindrome` is the safer version.

* Both versions leave the input list modified (the second half stays reversed). That passes LeetCode, but in a real codebase I would reverse it back before returning.

* **Time Complexity:** `O(n)` covering the find-middle, reverse and compare passes.

* **Space Complexity:** `O(1)` because I reverse in place instead of copying values into an array or stack.

* **Important Edge Cases:** empty list, single node, two equal / two different nodes, odd vs even length.

---

## 5. MERGE TWO SORTED LISTS

* The approach I use is a **dummy node with a tail pointer** (`MergeTwoLists` and `MergeTwoSortedLists` contain the same code).

* I create `dummy = new ListNode(0)` so I never have to special-case "which node becomes the head?".

* `current` always points to the last node of the merged list.

* While both `list1` and `list2` have nodes, I attach the smaller one to `current.next` and advance that list's pointer. When the values are equal, the `else` branch takes from `list2`.

* After each attachment, `current` moves forward.

* When one list runs out, the other is already sorted, so I attach the rest of it in one step: `current.next = list1` or `current.next = list2`.

* I return `dummy.next` because the dummy itself is not part of the answer.

* **Time Complexity:** `O(m + n)`.

* **Space Complexity:** `O(1)` because I relink the existing nodes instead of creating new ones.

* **Important Edge Cases:** one or both lists empty, duplicate values, all of one list smaller than the other.

---

## 6. REMOVE DUPLICATES FROM SORTED LIST

* Because the list is **sorted**, duplicates are always next to each other, so I only compare each node with its neighbour (`DeleteDuplicates`).

* While `current` and `current.next` both exist:

    * If `current.val == current.next.val`, I skip the duplicate with `current.next = current.next.next`. I **do not move** `current`, because the new `current.next` might be another duplicate.
    * Otherwise, I move `current` forward.

* The head can never be removed (the first copy is always kept), so I return `head` and need no dummy.

* **Time Complexity:** `O(n)`.

* **Space Complexity:** `O(1)`.

* **Important Edge Cases:** empty list, all nodes equal, three or more duplicates in a row.

---

## 7. REMOVE LINKED LIST ELEMENTS

* The approach I use is a **dummy node in front of `head`** (`RemoveElements`), because the head itself may need to be removed.

* `current` starts at the dummy and I always look one node ahead at `current.next`.

* If `current.next.val == val`, I unlink it with `current.next = current.next.next` and stay where I am, since the next node might also match.

* Otherwise, I move `current` forward.

* I return `dummy.next`, which is the new head even if the original head was removed.

* **Time Complexity:** `O(n)`.

* **Space Complexity:** `O(1)`.

* **Important Edge Cases:** empty list, every node equals `val`, matching nodes at the head or tail.

---

## 8. REMOVE NTH NODE FROM END OF LIST

* I have three implementations across `RemoveNthNode` and `RemoveNthFromEnd`, using two approaches.

* **Approach 1 – Length counter (`RemoveNthNode.removeNthFromEnd` and `RemoveNthFromEnd.removeNthFromEnd`, which are the same logic):**

    * The first pass counts `length`.
    * If `length == n`, the node to remove is the head, so I return `head.next`.
    * Otherwise, I walk `current` forward `steps = length - n - 1` times. That lands on the node **just before** the one to remove.
    * I unlink it with `current.next = current.next.next`.
    * This takes two passes.

* **Approach 2 – Dummy and two pointers with a gap (`RemoveNthFromEnd.removeNthNode`):**

    * I put a `dummy` before `head` and start both `fast` and `slow` at the dummy.
    * I move `fast` ahead `n + 1` times (`i <= n`), creating a gap of `n` nodes between them.
    * I then move both together until `fast` is `null`. `slow` is now right before the target node.
    * `slow.next = slow.next.next` removes it, and I return `dummy.next`.
    * The dummy handles removing the head without a special case, and it takes **one pass**.

* **Comparison:** both are `O(n)`, but approach 2 is single-pass and has no `length == n` special case, which is why it is the usual interview answer.

* **Time Complexity:** `O(n)`.

* **Space Complexity:** `O(1)`.

* **Important Edge Cases:** single-node list with `n = 1`, removing the head (`n == length`), removing the tail (`n = 1`).

---

## 9. INTERSECTION OF TWO LINKED LISTS

* Intersection means both lists point to the **same node in memory**, not just a node with the same value. After that node, the rest of both lists is shared.

* The approach I use is **two pointers that switch lists** (`GetIntersectionNode`).

* `A` starts at `headA` and `B` starts at `headB`.

* While `A != B`:

    * `A` moves forward, and when it falls off the end it jumps to `headB`.
    * `B` moves forward, and when it falls off the end it jumps to `headA`.

* This works because each pointer walks `lengthA + lengthB` nodes in total, so they line up and meet at the intersection after at most two passes.

* If there is no intersection, both reach `null` at the same time, the loop ends because `null == null`, and I return `null`.

* **Time Complexity:** `O(m + n)`.

* **Space Complexity:** `O(1)`, compared with `O(m)` for a HashSet of visited nodes.

* **Important Edge Cases:** no intersection, one list empty, intersection at the first node, lists of different lengths.

---

## 10. ADD TWO NUMBERS

* The digits are stored in **reverse order** (ones digit first), so I can add from the head just like column addition on paper (`AddTwoNumbers`).

* I use a `dummy` node to build the answer and a `curr` pointer as its tail.

* `carry` starts at `0`.

* I loop while `l1 != null || l2 != null || carry != 0`. The `carry != 0` condition makes sure a final carry, as in `5 + 5 = 10`, still produces a node.

* On each step:

    * `x` and `y` are the current digits, or `0` if that list has run out.
    * `sum = x + y + carry`.
    * `digit = sum % 10` is what I write down, and `carry = sum / 10` is what I carry over.
    * I advance `l1` and `l2` if they are not `null`.
    * I append `new ListNode(digit)` and move `curr`.

* I return `dummy.next`.

* **Time Complexity:** `O(max(m, n))`.

* **Space Complexity:** `O(max(m, n))` for the new result list.

* **Important Edge Cases:** lists of different lengths, a carry left over at the end, both numbers `0`.

---

## 11. PARTITION LIST

* The approach I use is **two dummy lists** (`Partition`): one for values `< x` and one for values `>= x`.

* `smallDummy` / `small` build the "less than" list, and `largeDummy` / `large` build the "greater or equal" list.

* I walk `current` through the original list and attach each node to the end of the matching list. This keeps the **original relative order** inside each partition.

* After the loop:

    * `large.next = null` ends the large list. This is critical: the last large node may still point to an old small node, which would create a cycle.
    * `small.next = largeDummy.next` joins the end of the small list to the start of the large list.

* I return `smallDummy.next`.

* **Time Complexity:** `O(n)`.

* **Space Complexity:** `O(1)` because I relink existing nodes and only create the two dummies.

* **Important Edge Cases:** empty list, all values `< x`, all values `>= x`, values equal to `x`.

---

## 12. REVERSE LINKED LIST II

* `left` and `right` are **positions** (1-indexed), not node values (`ReverseBetween`).

* If `left == right`, there is nothing to reverse, so I return `head`.

* I use a `dummy` before `head` so that reversing from position `1` needs no special case.

* I walk `beforeLeft` from the dummy `left - 1` times so it stops on the node **just before** the section to reverse.

* `current = beforeLeft.next` is the first node of the section. It ends up as the last node of the reversed section, and it stays fixed while the nodes after it are moved.

* I then repeat `right - left` times, each time **moving the node after `current` to the front of the section**:

    * `nextNode = current.next` is the node to move.
    * `current.next = nextNode.next` removes `nextNode` from its spot.
    * `nextNode.next = beforeLeft.next` points it at the current front of the section.
    * `beforeLeft.next = nextNode` makes it the new front.

* I return `dummy.next`.

* **Time Complexity:** `O(n)` with a single pass.

* **Space Complexity:** `O(1)`.

* **Important Edge Cases:** `left == right`, `left = 1` (head changes), `right` equal to the list length, single-node list.

---

## 13. ODD EVEN LINKED LIST

* "Odd" and "even" refer to the node **positions** (1st, 3rd, 5th… vs 2nd, 4th…), not the values. My early notes in the file considered `val % 2`, but the final code groups by position (`OddEvenList`).

* If the list has zero or one node, I return `head` as it is.

* I use three pointers:

    * `odd` -> the tail of the odd-position chain, starting at `head`.
    * `even` -> the tail of the even-position chain, starting at `head.next`.
    * `evenHead` -> the start of the even chain, saved so I can attach it at the end.

* While `even != null && even.next != null`:

    * `odd.next = even.next`, then `odd = odd.next` links the next odd-position node.
    * `even.next = odd.next`, then `even = even.next` links the next even-position node.

* Finally, `odd.next = evenHead` attaches all even-position nodes after the odd ones.

* Relative order inside each group is preserved.

* **Time Complexity:** `O(n)`.

* **Space Complexity:** `O(1)`.

* **Important Edge Cases:** empty list, one node, two nodes, odd vs even length.
