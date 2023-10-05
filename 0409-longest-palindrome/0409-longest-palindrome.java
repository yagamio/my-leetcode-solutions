/**
 * 409. Longest Palindrome
 * HashMap
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        int remainer = 0;
        int[] frequency = new int[52];
        for (char x : s.toCharArray()) {
            // distinguish big and small cases
            if (x >= 'a' && x <= 'z') {
                frequency[x - 'a'] += 1;
            } else {
                frequency[x - 'A' + 26] += 1;
            }
        }
        for (int i = 0; i < 52; i++) {
            int left = frequency[i] % 2;
            if (left != 0) {
                remainer = 1;
            }
            count += frequency[i] - left;
        }
        return count + remainer;
    }
}