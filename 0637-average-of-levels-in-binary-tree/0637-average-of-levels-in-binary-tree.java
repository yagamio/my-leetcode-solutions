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
 * 637. Average of Levels in Binary Tree
 * Iteration. Level.
 * Time complexity: O(N)
 * Space complexity: O(H)
 */
class Solution {
    private List<Double> result = new ArrayList<>();
    
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int temp = len;
            double sum = 0;
            while (temp > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                sum += cur.val;
                temp --;
            }
            result.add(sum / len);
        }
        return result;
    }
}