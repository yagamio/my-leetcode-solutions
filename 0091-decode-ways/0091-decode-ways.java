/**
 * 91. Decode Ways
 * Dynamic programming
 */
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') return 0;
                dp[i] = i == 1 ? 1 : dp[i - 2];
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) - '0' > 0 && s.charAt(i) - '0' < 7)) {
                dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        
        return dp[len - 1];
    }
}