/**
 * 78. Subsets
 * Backtracking
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        boolean[] visited = new boolean[nums.length];
        findSubsets(0, subsets, visited, nums, new ArrayList<>());
        return subsets;
    }

    private void findSubsets(int k, List<List<Integer>> subsets, boolean[] visited, int[] nums, List<Integer> tempSet) {
        for (int i = k; i < nums.length; i++) {
            if (visited[i]) {
                return;
            }
            tempSet.add(nums[i]);
            visited[i] = true;
            subsets.add(new ArrayList<>(tempSet));
            findSubsets(k + 1, subsets, visited, nums, tempSet);
            tempSet.remove(tempSet.size() - 1);
            visited[i] = false;
        }
    }
}