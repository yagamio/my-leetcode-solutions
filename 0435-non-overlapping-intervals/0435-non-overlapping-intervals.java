/**
 * 435. Non-overlapping Intervals
 * Greedy
 * N is the number of intervals
 * Time complexity: O(NlogN), sort
 * Space complexity: O(1)
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // sort intervals by the end element
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 1; // the number of non-overlapping intervals
        int end = intervals[0][1]; // the end of current non-overlapping internal
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return intervals.length - count;
    }
}