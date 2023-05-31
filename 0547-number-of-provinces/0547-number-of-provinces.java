/**
 * 547. Number of Provinces
 * DFS.
 * N is the number of cities.
 * Time complexity: O(N).
 * Space complexity: O(N). Set of components.
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // Create space for result, a set of components
        Set<Set<Integer>> components = new HashSet<>();
        // Document if a node is visited
        int cityCount = isConnected.length;
        boolean[] visited = new boolean[cityCount];
        for (int i = 0; i < cityCount; i++) {
            visited[i] = false;
        }
        // Iterate each node with DFS, detect its component
        for (int i = 0; i < cityCount; i++) {
            if (!visited[i]) { // Attention! Only create a new component when not visited
                HashSet<Integer> component = new HashSet<>();
                detectComponent(isConnected, i, visited, component);
                components.add(component);
            }
        }
        return components.size();
    }

    private void detectComponent(int[][] isConnected, int i, boolean[] visited, HashSet component) {
        visited[i] = true;
        component.add(i);
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) { // If j is the neighbor of i
                detectComponent(isConnected, j, visited, component);
            }
        }
    }
}