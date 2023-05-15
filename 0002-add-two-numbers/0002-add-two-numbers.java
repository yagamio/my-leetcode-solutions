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
class Solution {
    // Iteration.
    // N is the size of l1, M is the size of l2.
    // Time complexity: O(max(M,N)).
    // Space complexity: O(max(M,N)) if dummy is counted else O(1).
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int next1 = 0; // to record if the sum of two >= 10
        int sum = 0;
        ListNode dummy = new ListNode(); // create a dummy to return result
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + next1; // get the sum of current level
            next1 = sum / 10; // get the quotient, will be used in the next level
            cur.next = new ListNode(sum % 10); // keep the remainder in the current level
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) { // if l1 is longer than l2
            sum = l1.val + next1; // same logic applies
            next1 = sum / 10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) { // if l2 is longer than l1
            sum = l2.val + next1;
            next1 = sum / 10;
            cur.next = new ListNode(sum % 10);
            l2 = l2.next;
            cur = cur.next;
        }
        if (next1 != 0) { // lastly, if next1 != 0, means we need another level
            cur.next = new ListNode(next1);
        }
        return dummy.next;
    }
}