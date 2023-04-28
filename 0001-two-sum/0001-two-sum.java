class Solution {
    // HashMap.
    // N is the size of nums.
    // Time complexity: O(N).
    // Space complexity: O(N).
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                result[0] = i;
                result[1] = map.get(diff);
                return result;
            }
        }
        return result;
    }
}