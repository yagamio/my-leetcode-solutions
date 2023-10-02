/**
 * 128. Longest Consecutive Sequence
 * HashMap
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], 1);
        }
        for (int i = 0; i < nums.length; i++) {
            searchForward(nums[i], count);
        }
        return findMax(count);
    }

    // dfs to search for longest consecutive
    private int searchForward(int num, Map<Integer, Integer> map) {
        if (!map.containsKey(num)) return 0;
        int cur = map.get(num);
        if (cur > 1) return cur;
        cur = searchForward(num + 1, map) + 1;
        map.put(num, cur);
        return cur;
    }

    private int findMax(Map<Integer, Integer> map) {
        int max = 1;
        for (int num : map.keySet()) {
            max = Math.max(max, map.get(num));
        }
        return max;
    }
}