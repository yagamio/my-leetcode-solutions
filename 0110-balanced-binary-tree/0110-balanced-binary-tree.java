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
 * 110. Balanced Binary Tree
 * Recursion
 * Time complexity: O(N)
 * Space complexity: O(H)
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int difference = Math.abs(leftHeight - rightHeight);
        if (difference > 1) return false;
        // 注意确保左子树和右子树都是平衡的
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}