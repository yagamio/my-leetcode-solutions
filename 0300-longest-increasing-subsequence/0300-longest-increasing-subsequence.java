/**
 * 300. Longest Increasing Subsequence
 * Dynamic programming
 * Time complexity: O(N^2)
 * Space complexity: O(N)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            int max = dp[0];
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}