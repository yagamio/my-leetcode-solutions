/**
 * 213. House Robber II
 * Dynamic programming
 * N is the length of int[] nums
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelper(nums, 0, len - 2), robHelper(nums, 1, len - 1));
    }

    private int robHelper(int[] nums, int start, int last) {
        int[] maxMoney = new int[nums.length];
        maxMoney[start] = nums[start];
        maxMoney[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= last; i++) {
            maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
        }
        return maxMoney[last];
    }
}