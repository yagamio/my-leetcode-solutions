/**
 * 695. Max Area of Island
 * DFS
 * Time complexity: O(m * n)
 * Space complexity: O(m * n), the maximum depth of DFS recursion
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[] area = {0};
                    searchIsland(i, j, grid, directions, area);
                    maxArea = Math.max(area[0], maxArea);
                }
            }
        }

        return maxArea;
    }

    private void searchIsland(int i, int j, int[][] grid, int[][] directions, int[] area) {
        grid[i][j] = -1;
        area[0] = area[0] + 1;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int[] direction : directions) {
            int p = i + direction[0];
            int q = j + direction[1];
            if (p >= 0 && p < m && q >= 0 && q < n && grid[p][q] == 1) {
                searchIsland(p, q, grid, directions, area);
            }
        }
    }
}