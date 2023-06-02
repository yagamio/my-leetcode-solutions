/**
 * 167. Two Sum II - Input Array Is Sorted
 * Double pointers
 * N is the size if int[] numbers
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int l = 0, r = numbers.length - 1; // double pointers
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }
}