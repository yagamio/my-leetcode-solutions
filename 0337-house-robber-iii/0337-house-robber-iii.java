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
 * 337. House Robber III
 * Dynamic programming. Hash map. Recursion.
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    private Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (cache.containsKey(root)) return cache.get(root); // avoid repetitive calculation
        
        // option 1: contains root
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        // option 2: exclude root
        int val2 = rob(root.left) + rob(root.right);
        
        int result = Math.max(val1, val2);
        cache.put(root, result);
        return result;
    }
}