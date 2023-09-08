/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Recursion. Inorder traversal.
 * Time complexity: O(N)
 * Space complexity: O(logN)
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null? null : createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int l, int h) {
        if (l > h) return null;
        int mid = l + (h - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, l, mid - 1);
        root.right = createBST(nums, mid + 1, h);
        return root;
    }
}