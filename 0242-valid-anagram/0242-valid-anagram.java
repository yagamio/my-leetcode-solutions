/**
 * 242. Valid Anagram
 * HashMap
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char x : s.toCharArray()) {
            count[x - 'a'] += 1;
        }
        for (char x : t.toCharArray()) {
            count[x - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}