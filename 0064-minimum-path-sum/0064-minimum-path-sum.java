/**
 * 64. Minimum Path Sum
 * Dynamic programming
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] pathLengths = new int[row][col];
        pathLengths[0][0] = grid[0][0];
        for (int i = 1; i <= col - 1; i++) {
            pathLengths[0][i] = pathLengths[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i <= row - 1; i++) {
            pathLengths[i][0] = pathLengths[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i <= row - 1; i++) {
            for (int j = 1; j <= col - 1; j++) {
                int leftPath = pathLengths[i][j - 1] + grid[i][j];
                int upPath = pathLengths[i - 1][j] + grid[i][j];
                pathLengths[i][j] = Math.min(leftPath, upPath);
            }
        }
        return pathLengths[row - 1][col - 1];
    }
}