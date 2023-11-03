/**
 * 565. Array Nesting
 * Iteration
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int arrayNesting(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            int cur = nums[i];
            // Note that sublists will not duplicate
            // so it works to mark visited elements to save time
            nums[i] = -1; // mark as visited
            while (cur != i && cur != -1) {
                len++;
                int next = nums[cur];
                nums[cur] = -1; // mark as visited
                cur = next;
            }
            result = Math.max(result, len);
        }
        return result;
    }
}