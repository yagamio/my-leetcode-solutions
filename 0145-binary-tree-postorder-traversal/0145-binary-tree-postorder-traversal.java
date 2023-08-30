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
class Solution {
    /**
     * 144. Binary Tree Postorder Traversal
     * Iteration. Stack. Based on pre-order traversal.
     * Time complexity: O(n).
     * Space complexity: O(n).
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) continue;
            results.add(cur.val);
            stack.push(cur.left);
            stack.push(cur.right);
        }
        Collections.reverse(results);
        return results;
    }
}