/**
 * 88. Merge Sorted Array
 * Two pointers
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null) return;
        // assign two pointers at the end of nums 1 and 2
        int p = m - 1, q = n - 1;
        // assign one pointer at the end of nums 1
        int x = nums1.length - 1;
        while (p >= 0 && q >= 0) {
            if (nums2[q] >= nums1[p]) {
                nums1[x] = nums2[q];
                q--;
                x--;
            } else {
                nums1[x] = nums1[p];
                p--;
                x--;
            }
        }
        if (q >= 0) { // if there are elements left in nums2
            for (int i = 0; i <= q; i++) {
                nums1[i] = nums2[i];
            }
        }
        return;
    }
}