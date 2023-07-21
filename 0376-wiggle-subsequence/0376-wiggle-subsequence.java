/**
 * 376. Wiggle Subsequence
 * Dynamic programming
 * Time complexity: O(N^2)
 * Space complexity: O(N)
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // 上升子序列
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) { // 下降子序列
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}