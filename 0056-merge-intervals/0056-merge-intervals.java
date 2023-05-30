/**
 * Sort solution
 * N is the size of intervals
 * Time complexity: O(NlogN)
 * Space complexity: O(N)
 */

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        ArrayList<int[]> result = new ArrayList<>();
        // Sort intervals based on the first element
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]); // lambda
        // Iteration
        for (int[] interval : intervals) {
            // Add interval to result list if its beginning > ending of interval in result list
            if (result.size() == 0 || interval[0] > result.get(result.size()-1)[1]) {
                result.add(interval);
            // If overlap, combine them by revising the interval in result list
            } else if (interval[1] > result.get(result.size()-1)[1]) {
                result.get(result.size()-1)[1] = interval[1];
            }
        }
        // Create a two dimention int array: int [row][column]
        return result.toArray(new int[result.size()][2]);
    }
}