/**
 * 769. Max Chunks To Make Sorted
 * Double pointers
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            // find the maximum in the first i + 1 elements
            max = Math.max(max, arr[i]);
            if (max == i) {
                result++;
            }
        }
        return result;
    }
}