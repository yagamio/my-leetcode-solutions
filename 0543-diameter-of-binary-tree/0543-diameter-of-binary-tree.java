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
 * 543. Diameter of Binary Tree
 * Recursion
 * Time complexity: O(N)
 * Space complexity: O(H)
 */
class Solution {
    private int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;        
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int cur = leftHeight + rightHeight; // calculate the diameter of this node
        if (cur > diameter) {
            diameter = cur;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}