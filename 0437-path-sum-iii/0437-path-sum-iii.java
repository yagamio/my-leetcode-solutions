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
 * Prefix sum, hash map, backtracking
 * Time complexity: O(N)
 * Space complexity: O(H)
 */
class Solution {
    int result = 0;
    int targetSum;
    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        this.targetSum = sum;
        map.put((long)0, 1);
        backtrack(root, (long)0);
        return result;
    }
    
    private void backtrack(TreeNode root, long sum) {
        if (root == null) return;
        sum += root.val;
        if ( map.containsKey(sum - targetSum) && map.get(sum - targetSum) >= 1 ) {
            result += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        backtrack(root.left, sum);
        backtrack(root.right, sum);
        map.put(sum, map.get(sum) - 1);
    }
}