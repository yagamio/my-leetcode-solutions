/**
 * 79. Word Search
 * DFS
 * N is the length of String word
 * Time complexity: O(row * col * 4^N)
 * Space complexity: O(N)
 */
class Solution {
    int row, col;
    private static final int[][] directions = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] visited = new int[row][col];
                    if (searchWord(1, i, j, board, word, directions, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean searchWord(int k, int r, int c, char[][] board, String word, int[][] directions, int[][] visited) {
        visited[r][c] = 1;
        if (k == word.length()) {
            return true;
        }
        for (int[] direction : directions) {
            int nextRow = r + direction[0];
            int nextCol = c + direction[1];
            if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && visited[nextRow][nextCol] != 1 && board[nextRow][nextCol] == word.charAt(k)) {
                if (searchWord(k + 1, nextRow, nextCol, board, word, directions, visited)) {
                    return true; // must have a return value here
                }
            }
        }
        visited[r][c] = 0; // reset visited flag if the current path is not successful
        return false;
    }
}