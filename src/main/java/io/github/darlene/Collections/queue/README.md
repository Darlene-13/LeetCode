# DOCUMENTATION OF THE APPROACH USED IN EACH QUEUE PROBLEM SOLVED

A `PriorityQueue` in Java is a **min-heap** by default: `poll()` always removes the smallest element according to the comparator.

## 1. TOP K FREQUENT ELEMENTS

* The approach I use is a **HashMap for counting plus a min-heap of size k**.

* First I count the frequencies in a `HashMap<Integer, Integer>` called `map`:

    * If `map` does not contain `num`, I put it with a count of `1`.
    * Otherwise, I increase its count by `1`.

* I create a `PriorityQueue<Map.Entry<Integer, Integer>>` called `pq` that compares entries by their **value** (the frequency):

  `(entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue())`

  This makes the least frequent entry the head of the heap.

* I go through `map.entrySet()`, offer each entry, and whenever `pq.size() > k` I `poll()` the least frequent entry.

* At the end, `pq` holds exactly the `k` most frequent entries. I poll them and put each `getKey()` into `result`.

* This works because the heap never holds more than `k` entries, and an entry is only removed when there are already `k` entries with a frequency at least as high.

* `topKFreq` is a second practice copy of the same algorithm.

* **Time Complexity:** `O(n log k)`. Counting is `O(n)`, and each of up to `n` unique entries costs `O(log k)` to offer or poll.

* **Space Complexity:** `O(n)` for the map plus `O(k)` for the heap.

* **Important Edge Cases:** `k` equal to the number of unique elements, all elements the same, and ties in frequency (any of the tied elements is accepted).

* **Note:** the code comment says a priority queue "sorts by the descending order". A Java `PriorityQueue` is a **min-heap**, which is why polling removes the *least* frequent entry.

* An array-based version and a bucket sort version are in [../list/arrays/](../list/arrays/README.md).
