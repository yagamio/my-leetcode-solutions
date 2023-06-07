/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * Greedy?
 * N is the length of points
 * Time complexity: O(NlogN)
 * Space complexity: O(N), for the result list
 * The goal is the count the number of non-overlapping intervals
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // sort intervals by the first element
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        // create space for non-overlapping intervals
        List<int[]> intervals = new ArrayList<>();
        intervals.add(points[0]);
        for (int i = 1; i < points.length; i++) {
            int[] lastInterval = intervals.get(intervals.size() - 1);
            if (points[i][0] <= lastInterval[1]) {
                lastInterval[1] = Math.min(lastInterval[1], points[i][1]);
                continue;
            }
            intervals.add(points[i]);
        }
        return intervals.size();
    }
}