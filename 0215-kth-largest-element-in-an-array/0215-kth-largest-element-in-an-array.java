/**
 * 215. Kth Largest Element in an Array
 * Java sort.
 * n is the size of nums.
 * Time complexity: O(nlogn).
 * Space complexity: O(1).
 */
class Solution {
    /**
     * Use java sort directly.
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}