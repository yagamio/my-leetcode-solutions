/**
 * 633. Sum of Square Numbers
 * Two pointers
 * N is the value of int c
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int l = 0, r = (int) Math.sqrt(c); // two pointers
        while (l <= r) {
            long sum = (long) l * l + (long) r * r;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}