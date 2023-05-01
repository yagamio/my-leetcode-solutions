/**
 * 75. Sort Colors
 * Selection sort.
 * n is the size of nums.
 * Time complexity: O(n ^ 2).
 * Space complexity: O(1).
 */
class Solution {
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = min;
            nums[minIndex] = temp;
        }
    }
}