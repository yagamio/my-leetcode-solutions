/**
 * 53. Maximum Subarray
 * Dynamic Programming
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        // create an array to store the max sum of subarray for each element of nums
        int[] maxSums = new int[nums.length];
        maxSums[0] = nums[0];
        int result = maxSums[0];

        for (int i = 1; i < nums.length; i++) {
            // for each element, the max sum is either itself, or add itself to previous sum
            maxSums[i] = Math.max(maxSums[i-1] + nums[i], nums[i]);
            result = Math.max(result, maxSums[i]);
        }

        return result;
    }
}