/**
 * 680. Valid Palindrome II
 * Two pointers
 * N is the length of string s
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null) return false;
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) return true;
        int p = l, q = r; // remember l and r
        l++;
        while (l <= r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) return true;
        l = p;
        r = q - 1;
        while (l <= r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) return true;
        return false;
    }
}