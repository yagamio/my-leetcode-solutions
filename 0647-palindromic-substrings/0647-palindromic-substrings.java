/**
 * 647. Palindromic Substrings
 * Brute force
 * Time complexity: O(N ^ 3)
 * Space complexity: O(N)
 */
class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        // convert string to char[]
        char[] list = s.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(list, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(char[] list, int start, int end) {
        if (start == end) {
            return true;
        }
        while (start <= end) {
            if (list[start] != list[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}