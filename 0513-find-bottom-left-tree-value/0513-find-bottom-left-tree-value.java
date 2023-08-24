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
 * 513. Find Bottom Left Tree Value
 * Iteration. Queue.
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    private List<List<Integer>> nodes = new ArrayList<>();

    private Queue<TreeNode> queue = new LinkedList<>();
    
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            while (len > 0) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                len--;
            }
            nodes.add(level);
        }
        return nodes.get(nodes.size() - 1).get(0);
    }
}