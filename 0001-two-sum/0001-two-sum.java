/**
 * 1. Two Sum
 * HashMap
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> differences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!differences.containsKey(nums[i])) {
                differences.put(target - nums[i], i);
            } else {
                result[0] = differences.get(nums[i]);
                result[1] = i;
            }
        }
        return result;
    }
}