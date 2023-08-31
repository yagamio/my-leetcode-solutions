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
 * 94. Binary Tree Inorder Traversal
 * Stack.
 * n is the size of TreeNode.
 * h is the height of TreeNode.
 * Time complexity: O(n)
 * Space comlexity: O(h)
 */
import java.util.ArrayList;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            results.add(node.val); // deal with root
            cur = node.right; // deal with right
        }
        return results;
    }
}