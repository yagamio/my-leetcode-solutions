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
 * 538. Convert BST to Greater Tree
 * Recursion
 * Time complexity: O(N)
 * Space complexity: O(H)
 */
class Solution {
    private int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        sum += root.val;
        root.val = sum;
        traversal(root.left);
    }
}