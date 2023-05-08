/**
 * 785. Is Graph Bipartite?
 * DFS.
 * n is the number of nodes. e is the number of edges.
 * Time complexity: O(n + e). 染色时，每条边连接的两个节点，都会被各遍历到2次
 * Space complexity: O(n).
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1); // create array to store colors for all nodes, start with -1
        for (int i = 0; i < graph.length; i++) {
            // iterate all nodes, color it with 0 first
            if (colors[i] == -1 && !isBipartiteDFS(i, 0, colors, graph)) return false;
        }
        return true;
    }

    private boolean isBipartiteDFS(int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) return colors[curNode] == curColor;
        colors[curNode] = curColor;
        for (int curNext : graph[curNode]) { // iterate all neiboring nodes with different color
            if (!isBipartiteDFS(curNext, 1 - curColor, colors, graph)) return false;
        }
        return true;
    }
}