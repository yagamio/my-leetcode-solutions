/**
 * 121. Best Time to Buy and Sell Stock
 * Greedy
 * N is the length of int[] prices
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (prices.length == 0) return 0;
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (prices[i] < soFarMin) soFarMin = prices[i];
            else max = Math.max(max, prices[i] - soFarMin);
        }
        return max;
    }
}