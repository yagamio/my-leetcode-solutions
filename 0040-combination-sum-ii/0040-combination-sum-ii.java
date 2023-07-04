/**
 * 40. Combination Sum II
 * Backtracking
 * Time complexity: O()
 * Space complexity: o()
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        HashSet<List<Integer>> uniqueCombos = new HashSet<>();
        combineHelper(0, uniqueCombos, candidates, target, new ArrayList<>());
        for (List<Integer> combo : uniqueCombos) {
            results.add(new ArrayList<>(combo));
        }
        return results;
    }

    private void combineHelper(int start, HashSet<List<Integer>> uniqueCombos, int[] candidates, int target, List<Integer> tempCombo) {
        if (target == 0) {
            uniqueCombos.add(new ArrayList<>(tempCombo));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempCombo.add(candidates[i]);
            combineHelper(i + 1, uniqueCombos, candidates, target - candidates[i], tempCombo);
            tempCombo.remove(tempCombo.size() - 1);
        }
    }
}