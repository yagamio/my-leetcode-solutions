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
 * 257. Binary Tree Paths
 * Backtracking. DFS.
 * H is the height of root
 * Time complexity: O(2^H)
 * Space complexity: O(2^H)
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        findPaths(root, paths, path);
        return paths;
    }

    private void findPaths(TreeNode root, List<String> paths, StringBuilder path) {
        if (root == null) {
            return;
        }
        int pathLength = path.length(); // remember the current length
        String curNode = String.valueOf(root.val);
        if (path.length() != 0) {
            curNode = "->" + curNode;
        }
        path.append(curNode);
        if (root.left == null && root.right == null) {
            paths.add(path.toString());
        } else {
            findPaths(root.left, paths, path);
            findPaths(root.right, paths, path);
        }
        path.setLength(pathLength); // restore the length of path before addition
    }
}