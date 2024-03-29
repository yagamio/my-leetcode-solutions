/**
 * 172. Factorial Trailing Zeroes
 * Iteration
 * Time complexity: O(logN)
 * Space complexity; O(N)
 */
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n / 5 != 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}