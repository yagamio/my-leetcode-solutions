/**
 * 279. Perfect Squares
 * BFS.
 * Time complexity: O(n * sqrt(n)). 因为求平方数的时间复杂度是sqrt(n).
 * Space complexity: O(n).
 */
class Solution {
    public int numSquares(int n) {
        List<Integer> squares = getSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(n);
        visited[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) break;
                    if (next == 0) return level;
                    if (visited[next]) continue;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    protected List<Integer> getSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}