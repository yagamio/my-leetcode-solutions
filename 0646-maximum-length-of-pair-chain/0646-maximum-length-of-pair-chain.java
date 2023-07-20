/**
 * 646. Maximum Length of Pair Chain
 * Dynamic programming
 * Time complexity: O(N^2)
 * Space complexity: O(N)
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(0);
    }
}