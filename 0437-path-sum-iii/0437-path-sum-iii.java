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
 * 437. Path Sum III
 * Recursion
 * Time complexity: O(N)
 * Space complexity: O(H)
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int ret = 0;
        ret += pathSumStartWithRoot(root, (long)sum);
        ret += pathSum(root.left, sum);
        ret += pathSum(root.right, sum);
        return ret;
    }

    private int pathSumStartWithRoot(TreeNode root, long sum) {
        if (root == null) return 0;
        int ret = 0;
        if (root.val == sum)
            ret++;
        ret += pathSumStartWithRoot(root.left, sum - root.val);
        ret += pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
}