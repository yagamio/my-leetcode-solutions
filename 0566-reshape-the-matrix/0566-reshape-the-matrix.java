/**
 * 566. Reshape the Matrix
 * Iteration
 * Time complexity: O(m * n)
 * Space complexity: O(1)
 */
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = mat[index / n][index % n];
                index++;
            }
        }
        return result;
    }
}