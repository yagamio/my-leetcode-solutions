/**
 * 122. Best Time to Buy and Sell Stock II
 * Greedy
 * N is the length of int[] prices
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N == 0) return 0;
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (prices[i] > prices[i - 1]) max = max + prices[i] - prices[i - 1];
        }
        return max;
    }
}