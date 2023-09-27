/**
 * 217. Contains Duplicate
 * HashMap
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)) {
                return true;
            } else {
                map.put(cur, 1);
            }
        }
        return false;
    }
}