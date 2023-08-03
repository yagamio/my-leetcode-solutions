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
 * 328. Odd Even Linked List
 * Iteration
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode oddCur = head;
        ListNode evenHead = head.next;
        ListNode evenCur = head.next;
        while ( evenCur != null && evenCur.next != null ) {
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;
            evenCur.next = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return oddHead;
    }
}