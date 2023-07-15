/**
 * 303. Range Sum Query - Immutable
 * Dynamic programming
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class NumArray {

    private int[] numsCopy;

    public NumArray(int[] nums) {
        numsCopy = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += numsCopy[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */