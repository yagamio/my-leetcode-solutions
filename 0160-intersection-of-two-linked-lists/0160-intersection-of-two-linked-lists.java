/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * 160. Intersection of Two Linked Lists
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode L1 = headA, L2 = headB;
        while (L1 != L2) {
            L1 = (L1 == null) ? headB : L1.next;
            L2 = (L2 == null) ? headA : L2.next;
        }
        return L1;
    }
}