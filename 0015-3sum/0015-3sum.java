/**
 * 15. 3Sum
 * Double pointers.
 * n is the size of nums.
 * time complexity: O(n^2).
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort nums.
        if (nums[0] > 0) { // means the minimum element > 0
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            // Avoid duplication for i.
            if (i > 0 && nums[i] == nums[i-1]) { // means if the current i == the last i, jump over it
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else { // when sum == 0
                    List<Integer> answer = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(answer);
                    // Avoid duplication for left and right by jumping over duplicate elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}