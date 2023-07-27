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
 * 21. Merge Two Sorted Lists
 * Iteration
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list2.val <= list1.val) {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
                cur.next = null;
            } else {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
                cur.next = null;
            }
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return dummy.next;
    }
}