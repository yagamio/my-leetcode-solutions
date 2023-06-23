/**
 * 130. Surrounded Regions
 * DFS
 * Time complexity: O(m * n)
 * Space complexity: O(m * n). List to store elements on edge.
 */
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] directions = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        List<int[]> onEdge = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        searchEdgeComponent(i, j, board, directions, onEdge);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    searchComponent(i, j, board, directions);
                }
            }
        }

        for (int[] edge : onEdge) {
            board[edge[0]][edge[1]] = 'O';
        }

    }

    private void searchComponent(int i, int j, char[][] board, int[][] directions) {
        board[i][j] = 'X';
        
        int m = board.length;
        int n = board[0].length;
        for (int[] direction : directions) {
            int p = i + direction[0];
            int q = j + direction[1];
            if (p >= 0 && p < m && q >= 0 && q < n && board[p][q] == 'O') {
                searchComponent(p, q, board, directions);
            }
        }
    }

    private void searchEdgeComponent(int i, int j, char[][] board, int[][] directions, List<int[]> onEdge) {
        board[i][j] = 'Y';
        onEdge.add(new int[] {i, j});
        
        int m = board.length;
        int n = board[0].length;
        for (int[] direction : directions) {
            int p = i + direction[0];
            int q = j + direction[1];
            if (p >= 0 && p < m && q >= 0 && q < n && board[p][q] == 'O') {
                searchEdgeComponent(p, q, board, directions, onEdge);
            }
        }
    }
}