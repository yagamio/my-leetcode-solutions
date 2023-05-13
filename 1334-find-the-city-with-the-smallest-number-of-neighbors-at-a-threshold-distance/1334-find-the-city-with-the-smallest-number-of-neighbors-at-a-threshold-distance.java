/**
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 * Floyd-Marshall algorithm.
 * n is the number of cities.
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 */
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // step1, create an array to store distance between 2 cities
        int[][] distance = new int[n][n];

        // step2, initiate all distances with max value (means not connected)
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // step3, update distance array with given edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            distance[from][to] = weight;
            distance[to][from] = weight;
        }

        // step4, use Floyd-Marshall to calculate minimum distances
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        // step5, iterate cities to get the answer
        int minCity = -1;
        int minCityNumber = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities <= minCityNumber) { // "=" must be added, we need the last one
                minCityNumber = reachableCities;
                minCity = i;
            }
        }

        return minCity;
    }
}