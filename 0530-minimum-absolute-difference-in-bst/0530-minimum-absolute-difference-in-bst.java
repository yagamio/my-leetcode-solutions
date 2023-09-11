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
 * 530. Minimum Absolute Difference in BST
 * Recursion. Inorder traversal. Two pointers.
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return -1;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int min = list.get(list.size() - 1);
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i) - list.get(i - 1);
            min = Math.min(min, temp);
        }
        return min;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}