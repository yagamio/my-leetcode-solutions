/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
 * 109. Convert Sorted List to Binary Search Tree
 * Recursion.
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return createBST(list, 0, list.size() - 1);
    }

    private TreeNode createBST(List<Integer> list, int l, int h) {
        if (l > h) return null;
        int mid = l + (h - l) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = createBST(list, l, mid - 1);
        root.right = createBST(list, mid + 1, h);
        return root;
    }
}