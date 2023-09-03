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
 * 230. Kth Smallest Element in a BST
 * Recursion.
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> traversal = new ArrayList<>();
        traversal.add(-1);
        inOrderTraversal(root, traversal);
        int result = -1;
        int count = 1;
        for (int i = 1; i < traversal.size(); i++) {
            if (count == k) {
                result = traversal.get(i);
                break;
            }
            if (traversal.get(i) == traversal.get(i - 1)) {
                continue;
            }
            count++;
        }
        return result;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> traversal) {
        if (root == null) return;
        inOrderTraversal(root.left, traversal);
        traversal.add(root.val);
        inOrderTraversal(root.right, traversal);
    }
}