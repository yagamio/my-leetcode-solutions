/**
 * 69. Sqrt(x)
 * Binary search
 * N is the value of int x
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (m == x / m) {
                return m;
            } else if (m < x / m) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return h;
    }
}