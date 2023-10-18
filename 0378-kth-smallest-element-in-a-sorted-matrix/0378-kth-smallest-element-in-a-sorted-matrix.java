/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * Binary search
 * Time complexity: O(n * log (hi - lo))
 * Space complexity: O(1)
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int count = 0;
            int mid = lo + (hi - lo) / 2;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    count++;
                }
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}