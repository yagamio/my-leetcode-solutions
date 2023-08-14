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
 * 572. Subtree of Another Tree
 * Recursion
 * N is the number of nodes of root.
 * M is the number of nodes of subRoot.
 * Time complexity: O(N * M)
 * Space complexity: O(H)
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        if (isEqual(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 != null) return false;
        if (node1 != null && node2 == null) return false;
        if (node1 == null && node2 == null) return true;
        if (node1.val != node2.val) return false;
        return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
    }
}