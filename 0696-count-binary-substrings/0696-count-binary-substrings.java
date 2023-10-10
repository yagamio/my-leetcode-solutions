/**
 * 696. Count Binary Substrings
 * Iteration. Brute force
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int len = s.length();
        int preLen = 0;
        int curLen = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }
}