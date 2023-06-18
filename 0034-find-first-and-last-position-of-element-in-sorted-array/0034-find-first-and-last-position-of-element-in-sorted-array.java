/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Binary search. Blue & Red. Twice.
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            int[] res = {-1, -1};
            return res;
        }

        int[] result = new int[2];
        
        int left1 = -1;
        int right1 = nums.length;
        while (left1 + 1 != right1) {
            int mid = left1 + ((right1 - left1) >> 1);
            if (nums[mid] < target) {
                left1 = mid;
            } else {
                right1 = mid;
            }
        }
        if (nums[right1] != target) {
            int[] res = {-1, -1};
            return res;
        }
        result[0] = right1;

        int left2 = -1;
        int right2 = nums.length;
        while (left2 + 1 != right2) {
            int mid = left2 + ((right2 - left2) >> 1);
            if (nums[mid] <= target) {
                left2 = mid;
            } else {
                right2 = mid;
            }
        }
        result[1] = left2;

        return result;
    }
}