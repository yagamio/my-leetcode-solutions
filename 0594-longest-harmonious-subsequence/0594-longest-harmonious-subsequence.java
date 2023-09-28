/**
 * 594. Longest Harmonious Subsequence
 * HashMap
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int findLHS(int[] nums) {
        int max = 0; // result
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!frequencies.containsKey(nums[i])) {
                frequencies.put(nums[i], 1);
            } else {
                int frequency = frequencies.get(nums[i]) + 1;
                frequencies.put(nums[i], frequency);
            }
        }
        for (int x : frequencies.keySet()) {
            if (frequencies.containsKey(x - 1)) {
                int cur = frequencies.get(x) + frequencies.get(x - 1);
                max = Math.max(max, cur);
            }
            if (frequencies.containsKey(x + 1)) {
                int cur = frequencies.get(x) + frequencies.get(x + 1);
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}