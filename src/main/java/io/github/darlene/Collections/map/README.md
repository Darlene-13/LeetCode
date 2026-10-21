# DOCUMENTATION OF THE APPROACH USED IN EACH MAP PROBLEM SOLVED

A `HashMap` stores **key -> value** pairs and has `O(1)` average time for lookups, which makes it useful for grouping and counting.

## 1. GROUP ANAGRAMS

* The approach I use is a **HashMap keyed by the sorted characters** of each word.

* Two words are anagrams if they have the same letters. If I sort their letters, I get the same string. For example, `"eat"`, `"tea"` and `"ate"` all become `"aet"`.

* I create a `HashMap<String, List<String>>` called `map`:

    * key -> the sorted characters of a word.
    * value -> the list of words that share that key.

* For each `word` in `strs`:

    * I convert it with `word.toCharArray()` into `chars`.
    * I sort it with `Arrays.sort(chars)`.
    * I build the `key` with `new String(chars)`.
    * If `map` does not contain the `key`, I create a new `ArrayList` for it.
    * I add the `word` to `map.get(key)`.

* At the end, I return `new ArrayList<>(map.values())`, where each value is one group of anagrams.

* **Time Complexity:** `O(n · k log k)`, where `n` is the number of words and `k` is the length of the longest word, because each word is sorted.

* **Space Complexity:** `O(n · k)` to store all the words and keys in the map.

* **Important Edge Cases:** an empty string `""` (it is grouped with other empty strings), a single word, words with no anagrams (each forms its own group), and repeated identical words.
