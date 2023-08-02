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
 * 725. Split Linked List in Parts
 * Iteration
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // calculate the length of head
        int N = 0;
        ListNode cur = head;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        int average = N / k; // length of each small linked list
        int mod = N % k; // number of small lists that needs addition

        // iterate head, divide linked list and attribute mod
        cur = head;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k && cur != null; i++) {
            result[i] = cur;
            int size = average + (mod-- <= 0 ? 0 : 1);
            for (int j = 0; j < size - 1; j++) {
                cur = cur.next;
            } 
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }
        return result;
    }
}