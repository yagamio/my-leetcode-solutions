/**
 * 153. Find Minimum in Rotated Sorted Array
 * Binary search. Blue & red.
 * isBlue: nums[blue] > nums[last]
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        if (nums[nums.length - 1] > nums[0]) { // if already sorted
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 != right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}