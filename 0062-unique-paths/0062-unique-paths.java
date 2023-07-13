/**
 * 62. Unique Paths
 * Dynamic programming
 * Time complexity: m * n
 * Space complexity: m * n
 */
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] paths = new int[m][n];
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (i == 0) {
                    paths[i][j] = 1;
                } else if (j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}