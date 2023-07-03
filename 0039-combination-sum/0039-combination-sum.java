/**
 * 39. Combination Sum
 * Backtracking
 * N is the length of candiates
 * K is the number of combinations
 * Time complexity: O(2^N * K)
 * Space complexity: O(N + K)
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        sumUp(0, candidates, target, combinations, new ArrayList<>());
        return combinations;
    }

    private void sumUp(int start, int[] candidates, int target, List<List<Integer>> combinations, List<Integer> tempCombo) {
        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombo));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            tempCombo.add(candidates[i]);
            sumUp(i, candidates, target - candidates[i], combinations, tempCombo);
            tempCombo.remove(tempCombo.size() - 1);
        }
    }
}