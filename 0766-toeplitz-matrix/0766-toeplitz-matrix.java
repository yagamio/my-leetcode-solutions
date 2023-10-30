/**
 * 766. Toeplitz Matrix
 * Iteration
 * Time complexity: O(m * n)
 * Space complexity: O(1)
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m <= 1 || n <= 1 || matrix == null) {
            return true;
        }
        for (int i = 0; i <= m - 2; i++) {
            for (int j = 0; j <= n - 2; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}