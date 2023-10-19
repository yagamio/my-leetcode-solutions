/**
 * 645. Set Mismatch
 * Hash map
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            frequency.put(i, 0);
        }
        for (int i = 0; i < nums.length; i++) {
            int count = frequency.get(nums[i]);
            frequency.put(nums[i], count + 1);     
        }
        for (int i = 1; i <= nums.length; i++) {
            int count = frequency.get(i);
            if (count == 2) {
                result[0] = i;
            }
            if (count == 0) {
                result[1] = i;
            }
        }
        return result;
    }
}