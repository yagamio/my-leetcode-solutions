/**
 * 90. Subsets II
 * Backtracking
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            findSubsets(i, 0, nums, subsets, new ArrayList<>());
        }
        return subsets;
    }

    private void findSubsets(int length, int start, int[] nums, List<List<Integer>> subsets, List<Integer> tempSet) {
        if (tempSet.size() == length) {
            subsets.add(new ArrayList<>(tempSet));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // Avoid duplicate elements
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempSet.add(nums[i]);
            findSubsets(length, i + 1, nums, subsets, tempSet);
            tempSet.remove(tempSet.size() - 1);
        }
    }
}