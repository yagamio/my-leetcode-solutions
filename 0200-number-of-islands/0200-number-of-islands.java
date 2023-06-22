/**
 * 200. Number of Islands
 * DFS. Connected components of a map.
 * Time complexity: O(m * n)
 * Space complexity: O(1)
 */
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int nums = 0;
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    searchIsland(i, j, grid, directions);
                }
            }
        }

        return nums;
    }

    // search the neighbors of "1" and mark them as "0" (visited)
    private void searchIsland(int i, int j, char[][] grid, int[][] directions) {
        grid[i][j] = '0';
        int m = grid.length;
        int n = grid[0].length; 
        
        for (int[] direction : directions) {
            int p = i + direction[0];
            int q = j + direction[1];
            if (p >= 0 && p < m && q >= 0 && q < n && grid[p][q] == '1') {
                searchIsland(p, q, grid, directions);
            }
        }
    }
}