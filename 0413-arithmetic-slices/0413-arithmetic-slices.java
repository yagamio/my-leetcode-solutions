/**
 * 413. Arithmetic Slices
 * Dynamic programming
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        
        // dp[i] means the number of subarrays that ends with element nums[i]
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i -1] - nums[i -2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        
        int total = 0;
        for (int num : dp) {
            total += num;
        }
        return total;
    }
}