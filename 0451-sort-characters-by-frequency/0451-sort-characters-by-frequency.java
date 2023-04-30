import java.util.Arrays;
import java.util.ArrayList;

/**
 * 451. Sort Characters By Frequency
 * Bucket sort.
 * n is the length of string s.
 * Time complexity: O(n).
 * Space complexity: O(n).
 */
class Solution {
    /**
     * Iterate string and put characters into HashMap.
     * Char as key, frequency as value.
     * Put characters into buckets, frequency as index.
     * Iterate buckets from the end, build and return new string.
     */
    public String frequencySort(String s) {
        // New string for result.
        StringBuilder sb = new StringBuilder();
        // Hashmap to store characters and frequency.
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashmap.put(c, hashmap.getOrDefault(c, 0) + 1);
        }
        // Create buckets.
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : hashmap.keySet()) {
            int frequency = hashmap.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }
        // Iterate buckets from the end, create new string.
        for (int i = s.length(); i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}