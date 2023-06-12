/**
 * 665. Non-decreasing Array
 * Greedy
 * N is the length of int[] nums
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int count = 0; // the number of changes
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i]; // first try decreasing i - 1
            }
        }
        return count < 2;
    }
}