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
 * 111. Minimum Depth of Binary Tree
 * Recursion
 * Time complexity: O(N)
 * Space complexity: O(H)
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0; // special case 1
        if (root.left == null) return minDepth(root.right) + 1; // special case 2
        if (root.right == null) return minDepth(root.left) + 1; // special case 3
        return Math.min( minDepth(root.left), minDepth(root.right) ) + 1;
    }
}