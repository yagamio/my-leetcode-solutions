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
 * 19. Remove Nth Node From End of List
 * Iteration
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp1 = head;
        while (temp1 != null) {
            len += 1;
            temp1 = temp1.next;
        }
        int target = len - n + 1; // the target.th element from the beginning
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        int count = 1; // when count == target, head points to the node to be deleted
        while (count < target) {
            head = head.next;
            pre = pre.next;
            count += 1;
        }
        pre.next = head.next;
        return dummy.next;
    }
}