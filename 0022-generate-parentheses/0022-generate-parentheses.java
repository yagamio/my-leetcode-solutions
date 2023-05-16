/**
 * 22. Generate Parentheses
 * Backtracking.
 * Time complexity: O(4^n / sqrt(n)). Hard to explain. 卡特兰数
 * Space complexity: O(N).
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, result, 0, 0, "");
        return result;
    }

    private void backtracking(int n, List<String> result, int left, int right, String str) {
        // exit conditions, two scenarios
        if (right > left) return;
        if (left == n && right == n) { // means current string is a valid result
            result.add(str);
            return;
        }

        // backtracking operations, two scenarios
        // backtracking method keeps track of the number of each parenthses
        // backtracking method adds "(" or ")" to currrent string
        if (left < n) backtracking(n, result, left + 1, right, str + "(");
        if (right < left) backtracking(n, result, left, right + 1, str + ")");
    }
}