/**
 * 540. Single Element in a Sorted Array
 * Binary search. Blue & Red.
 * N is the length of int[] nums
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // three marginal cases
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        // blue & red binary search, single element falls in red
        int left = -1;
        int right = nums.length;
        while (left + 1 != right) {
            int mid = left + ((right - left) >> 1);
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1]) { // isBlue
                left = mid;
            } else if (mid % 2 == 1 && nums[mid] != nums[mid + 1]) { // isBlue
                left = mid;
            } else { // not isBlue
                right = mid;
            }
        }
        
        return nums[right];
    }
}