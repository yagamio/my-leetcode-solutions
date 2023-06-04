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
        // first time left != right
        if (l >= r) return true;
        
        int p = l, q = r; // remember the index of l and r
        
        // delete left, check if the rest of string meets requirements
        l++;
        while (l <= r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) return true;
        
        // if not, then delete right and check
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