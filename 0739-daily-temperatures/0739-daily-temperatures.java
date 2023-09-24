/**
 * 739. Daily Temperatures
 * Stack
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] results = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                results[preIndex] = curIndex - preIndex;
            }
            indexs.push(curIndex);
        }
        return results;
    }
}