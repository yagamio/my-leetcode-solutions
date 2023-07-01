/**
 * 47. Permutations II
 * Backtracking
 * N is the length of int[] nums
 * Time complexity: O(N!)
 * Space complexity: O(N!)
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        HashSet<List<Integer>> uniquePermutes = new HashSet<>();
        boolean[] isVisited = new boolean[nums.length];
        permuteHelper(nums, uniquePermutes, isVisited, new ArrayList<>());
        for (List<Integer> permutation : uniquePermutes) {
            permutations.add(permutation);
        }
        return permutations;
    }

    private void permuteHelper(int[] nums, HashSet<List<Integer>> uniquePermutes, boolean[] isVisited, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            uniquePermutes.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            int num = nums[i];
            permutation.add(num);
            permuteHelper(nums, uniquePermutes, isVisited, permutation);
            permutation.remove(permutation.size() - 1);
            isVisited[i] = false;
        }
    }
}