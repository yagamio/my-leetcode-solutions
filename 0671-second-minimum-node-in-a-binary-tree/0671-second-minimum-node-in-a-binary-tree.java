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
 * 671. Second Minimum Node In a Binary Tree
 * Recursion
 * Time complexity: O(N)
 * Space complexity: O(H)
 */
class Solution {
    private long result = Long.MAX_VALUE; // larger than all possible input

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null) return -1; // then root.right also is null
        if (root.val == root.left.val && root.val == root.right.val) {
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        } else if (root.left.val > root.val) {
            result = Math.min(result, root.left.val);
            findSecondMinimumValue(root.right);
        } else if (root.right.val > root.val) {
            result = Math.min(result, root.right.val);
            findSecondMinimumValue(root.left);
        }
        return (result == Long.MAX_VALUE)? -1 : (int)result;
    }
}