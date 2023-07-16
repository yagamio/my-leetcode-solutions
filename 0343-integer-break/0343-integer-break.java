/**
 * 343. Integer Break
 * Dynamic programming
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                // 这里别忘了还要和当前的dp[i]做比较
                dp[i] = Math.max( dp[i], Math.max(j * (i - j), j * dp[i - j]) );
            }
        }
        return dp[n];
    }
}