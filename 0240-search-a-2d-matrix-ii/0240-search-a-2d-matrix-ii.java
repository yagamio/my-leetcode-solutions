/**
 * 240. Search a 2D Matrix II
 * Binary search (red & blue)
 * Time complexity: O(m * logn)
 * Space complexity: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > target || matrix[i][n - 1] < target) {
                continue;
            } else if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int l = -1;
        int r = row.length;
        while (l + 1 != r) {
            int m = (l + r) / 2;
            if (row[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (row[r] == target) {
            return true;
        } else {
            return false;
        }
    }
}