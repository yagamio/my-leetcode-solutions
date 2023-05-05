/**
 * 215. Kth Largest Element in an Array
 * Quick select (partition method from quick sort).
 * n is the length of nums.
 * Time complexity: O(n).
 * Space complexity: O(1).
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k);
    }

    protected int quickSelect(int[]nums, int k) {
        // partition中求出的是第j小的数，而不是第j大，所以要先转换成第x小
        // 数组中，第j大即为第nums.length - j小
        int x = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);
            if (j == x) {
                break;
            } else if (j > x) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return nums[x];
    }

    protected int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (less(nums[++i], nums[l]) && i != h);
            while (less(nums[l], nums[--j]) && j != l);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    protected boolean less(int v, int w) {
        return v < w;
    }

    protected void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}