/**
 * 46. Permutations
 * Backtracking
 * N is the length of int[] nums
 * Time complexity: O(N * N!)
 * Space complexity: O(N)
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int num : nums) {
            visited.put(num, false);
        }
        findPermutations(nums, results, visited, new ArrayList<>());
        return results;
    }

    private void findPermutations(int[] nums, List<List<Integer>> results, HashMap<Integer, Boolean> visited, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!visited.get(num)) {
                permutation.add(num);
                visited.put(num, true);
                findPermutations(nums, results, visited, permutation);
                permutation.remove(permutation.size() - 1);
                visited.put(num, false);
            }
        }
    }
}