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
 * 144. Binary Tree Preorder Traversal
 * Iteration. Stack.
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) continue; // check if a null root has been pushed in
            results.add(cur.val);
            stack.push(cur.right); // right in first so it comes out after left
            stack.push(cur.left);
        }
        return results;
    }
}