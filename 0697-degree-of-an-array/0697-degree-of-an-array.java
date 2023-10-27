/**
 * 697. Degree of an Array
 * HashMap
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        int result = nums.length;
        int maxFre = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (!map.containsKey(cur)) {
                // array[0] = frequency, array[1] = 1st index, array[2] = last index
                map.put(cur, new int[] {1, i, i});
            } else {
                int[] array = map.get(nums[i]);
                array[0] = array[0] + 1;
                array[2] = i;
            }
            maxFre = Math.max(maxFre, map.get(nums[i])[0]);
        }
        for (int x : map.keySet()) {
            int[] array = map.get(x);
            if (array[0] == maxFre) {
                int len = array[2] - array[1] + 1;
                result = Math.min(result, len);
            }
        }
        return result;
    }
}