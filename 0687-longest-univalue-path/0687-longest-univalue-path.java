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
 * 687. Longest Univalue Path
 * Recurision.
 * Time complexity: O(N)
 * Space complexity: O(H)
 */
class Solution {
    private int path;

    public int longestUnivaluePath(TreeNode root) {
        findPaths(root);
        return path;
    }

    private int findPaths(TreeNode root) {
        if (root == null) return 0;
        int left = findPaths(root.left);
        int right = findPaths(root.right);
        int leftPaths = (root.left != null && root.left.val == root.val)? left + 1 : 0;
        int rightPaths = (root.right != null && root.right.val == root.val)? right + 1 : 0;
        path = Math.max( path, leftPaths + rightPaths );
        return Math.max(leftPaths, rightPaths);
    }
}