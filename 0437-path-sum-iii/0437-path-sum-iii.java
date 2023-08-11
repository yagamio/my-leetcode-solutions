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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        // 前序遍历，根左右
        int pathsRoot = pathSumStartWithRoot(root, (long)targetSum);
        int pathsLeft = pathSum(root.left, targetSum);
        int pathsRight = pathSum(root.right, targetSum);
        return pathsRoot + pathsLeft + pathsRight;
    }

    private int pathSumStartWithRoot(TreeNode root, long sum) {
        if (root == null) return 0;
        int result = 0;
        // 处理根节点，由于不限制起始位置，只要相等，就多一条路
        if (root.val == sum) {
            result++;
        }
        // 递归处理左右节点
        int left = pathSumStartWithRoot(root.left, sum - root.val);
        int right = pathSumStartWithRoot(root.right, sum - root.val);
        result = result + left + right;
        return result;
    }
}