/**
 * 75. Sort Colors
 * Hashmap.
 * n is the size of nums.
 * Time complexity: O(n).
 * Space complexity: O(1).
 */
class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> frequencyOfNums = new HashMap<>();
        for (int num : nums) {
            frequencyOfNums.put(num, frequencyOfNums.getOrDefault(num, 0) + 1);
        }
        int j = 0;
        for (int num : frequencyOfNums.keySet()) {
            int frequency = frequencyOfNums.get(num);
            for (int i = 0; i < frequency; i++) {
                nums[j++] = num;
            }
        }
    }
}