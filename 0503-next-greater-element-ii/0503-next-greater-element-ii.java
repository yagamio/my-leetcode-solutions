/**
 * 503. Next Greater Element II
 * Stack
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] results = new int[N]; // space for results
        Stack<Integer> indexs = new Stack<>();
        int[] nums2 = new int[N * 2]; // new array for circular iteration
        for (int i = 0; i < N * 2; i++) {
            if (i < N) {
                nums2[i] = nums[i];
            } else {
                nums2[i] = nums[i - N];
            }
        }
        int[] results2 = new int[N * 2]; // temperary results
        for (int i = 0; i < N * 2; i++) {
            results2[i] = -1;
        }
        // iterate nums2 and store greater elements in results2
        for (int curIndex = 0; curIndex < N * 2; curIndex++) {
            while (!indexs.isEmpty() && nums2[curIndex] > nums2[indexs.peek()]) {
                int preIndex = indexs.pop();
                results2[preIndex] = nums2[curIndex];
            }
            indexs.push(curIndex);
        }
        for (int i = 0; i < N; i++) {
            results[i] = results2[i];
        }
        return results;
    }
}