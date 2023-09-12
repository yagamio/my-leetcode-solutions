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
 * 501. Find Mode in Binary Search Tree
 * Recursion. Inorder traversal. Hash table.
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        // Iterate traversal list and create frequency table
        List<List<Integer>> frequencyTable = new ArrayList<>();
        for (int i = 0; i <= list.size(); i++) {
            frequencyTable.add(new ArrayList<>());
        }
        int cur = list.get(0);
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == cur) {
                count++;
            } else {
                frequencyTable.get(count).add(cur);
                cur = list.get(i);
                count = 1;
            }
        }
        frequencyTable.get(count).add(cur); // Add the last element
        
        // Convert array list to int[]
        List<Integer> temp = new ArrayList<>();
        for (int i = list.size(); i >= 1; i--) {
            if (frequencyTable.get(i).size() != 0) {
                temp = frequencyTable.get(i);
                break;
            }
        }
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}