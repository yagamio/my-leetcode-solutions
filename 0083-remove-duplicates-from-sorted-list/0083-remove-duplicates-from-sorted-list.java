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
 * 83. Remove Duplicates from Sorted List
 * Iteration
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}