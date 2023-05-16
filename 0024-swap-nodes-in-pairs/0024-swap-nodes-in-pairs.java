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
  * 24. Swap Nodes in Pairs
  * Recursion.
  * Time complexity: O(N).
  * Space complexity: O(N).
  */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { // exit condition
            return head;
        }
        ListNode next = head.next; // let the second element be head
        head.next = swapPairs(head.next.next); // head points to later nodes (swapped)
        next.next = head; // second node points to the first (swap them)
        return next;
    }
}