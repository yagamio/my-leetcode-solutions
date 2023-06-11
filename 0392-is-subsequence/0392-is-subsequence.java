/**
 * 392. Is Subsequence
 * N is the length of String t
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0; // points at the shorter string t
        // iterate the longer string s
        for (int i = 0; i < t.length(); i++) {
            if (j < s.length() && t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        return s.length() == j;
    }
}