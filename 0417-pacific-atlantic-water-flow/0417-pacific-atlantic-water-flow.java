/**
 * 417. Pacific Atlantic Water Flow
 * DFS. Connected components.
 * Time complexity: O(row * col)
 * Space complexity: O(row * col)
 */
class Solution {

    int row, col;
    int[][] directions = new int[][] { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
    int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        row = heights.length;
        col = heights[0].length;
        matrix = heights;
        if (row == 0 || col == 0) {
            return result;
        }
        boolean[][] canReachPacific = new boolean[row][col];
        boolean[][] canReachAtlantic = new boolean[row][col];
        
        // search from the left and right borders for elements that can reach ocean
        for (int i = 0; i < row; i++) {
            canReachOcean(i, 0, canReachPacific);
            canReachOcean(i, col - 1, canReachAtlantic);
        }
        // search from the top and bottom borders for elements that can reach ocean
        for (int i = 0; i < col; i++) {
            canReachOcean(0, i, canReachPacific);
            canReachOcean(row - 1, i, canReachAtlantic);
        }
        // iterate and find elements that can reach both oceans
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (canReachPacific[r][c] && canReachAtlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void canReachOcean(int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] direction : directions) {
            int nextR = r + direction[0];
            int nextC = c + direction[1];
            // if next element is outside, or is higher, then skip it
            if (nextR < 0 || nextR >= row || nextC < 0 || nextC >= col || matrix[r][c] > matrix[nextR][nextC]) {
                continue;
            }
            canReachOcean(nextR, nextC, canReach);
        }
    }

}