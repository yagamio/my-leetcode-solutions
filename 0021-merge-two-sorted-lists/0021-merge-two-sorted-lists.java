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
 * Iteration.
 * Time complexity: O(N).
 * Space comlexity: O(N).
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1; // cur.next == whoever is smaller
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next; // move the current pointer
        }
        if (list1 == null) cur.next = list2; // deal with the remainders
        else cur.next = list1;
        return dummy.next;
    }
}