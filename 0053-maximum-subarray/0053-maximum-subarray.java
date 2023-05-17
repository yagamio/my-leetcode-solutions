/**
 * 53. Maximum Subarray
 * Dynamic Programming
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}