/**
 * 1091. Shortest Path in Binary Matrix
 * BFS.
 * m is the row of grid. n is the column of grid.
 * Time complexity: O(m * n).
 * Space complexity: O(m * n).
 */
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // deal with marginal cases
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        
        // create room for result
        int pathLength = 0;
        // create queue for bredth first search
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        // create a matrix for 8 possible travel directions
        int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1} };

        int m = grid.length, n = grid[0].length;
        queue.add(new Pair<>(0, 0));
        
        // start to iterate the queue
        while (!queue.isEmpty()) {
            pathLength++;
            int size = queue.size();
            // deal with each element in the queue
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                if (grid[cr][cc] == 1) continue;
                if (cr == m - 1 && cc == n - 1) return pathLength;
                grid[cr][cc] = 1; // mark cur as visited
                // add the next layer of cur to the queue (8 directions)
                for (int[] d : directions) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}