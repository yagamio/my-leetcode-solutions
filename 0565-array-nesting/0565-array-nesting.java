/**
 * 565. Array Nesting
 * Iteration
 * Time complexity: O(N)?
 * Space complexity: O(1)
 */
class Solution {
    public int arrayNesting(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            int cur = nums[i];
            nums[i] = -1;
            while (cur != i && cur != -1) {
                len++;
                int temp = nums[cur];
                nums[cur] = -1;
                cur = temp;
            }
            result = Math.max(result, len);
        }
        return result;
    }
}