/**
 * 684. Redundant Connection
 * Union Find. DFS.
 * n is the number of edges.
 * Time complexity: O(n).
 * Space complexity: O(n).
 */
class Solution {
    
    public int[] findRedundantConnection(int[][] edges) {
        int nodeCount = edges.length;
        unionFind uf = new unionFind(nodeCount);
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            if (uf.connected(node1, node2)) {
                return edge;
            }
            uf.union(node1, node2);
        }
        return new int[]{-1, -1};
    }

    private class unionFind {

        private int[] parent;

        // Initiate and create a parent array
        unionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }
        }

        private void union(int v, int w) {
            parent[find(v)] = parent[find(w)];
        }

        private int find(int v) {
            if (parent[v] != v) {
                parent[v] = find(parent[v]);
            }
            return parent[v];
        }

        private boolean connected(int v, int w) {
            return find(v) == find(w);
        }

    }

}