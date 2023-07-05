/**
 * 216. Combination Sum III
 * Backtracking
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        findCombos(1, k, n, results, new ArrayList<>());
        return results;
    }

    private void findCombos(int start, int k, int target, List<List<Integer>> results, List<Integer> combo) {
        if (combo.size() == k) {
            if (target == 0) {
                results.add(new ArrayList<>(combo));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (target - i < 0) {
                break;
            }
            combo.add(i);
            findCombos(i + 1, k, target - i, results, combo);
            combo.remove(combo.size() - 1);
        }
    }
}