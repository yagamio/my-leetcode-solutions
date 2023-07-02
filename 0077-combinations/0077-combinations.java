/**
 * 77. Combinations
 * Backtracking
 * Time complexity: O(n^2)
 * Space complexity: O(n!)
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        boolean[] isVisited = new boolean[n + 1];
        combineHelper(n, k, combinations, isVisited, new ArrayList<>());
        return combinations;
    }

    private void combineHelper(int n, int k, List<List<Integer>> combinations, boolean[] isVisited, List<Integer> combination) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (!combination.isEmpty() && i <= combination.get(combination.size() - 1)) {
                continue;
            }
            isVisited[i] = true;
            combination.add(i);
            combineHelper(n, k, combinations, isVisited, combination);
            isVisited[i] = false;
            combination.remove(combination.size() - 1);
        }
    }
}