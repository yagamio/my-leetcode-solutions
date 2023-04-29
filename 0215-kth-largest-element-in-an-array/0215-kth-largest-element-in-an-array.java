/**
 * 215. Kth Largest Element in an Array
 * Heap.
 * n is the size of nums.
 * Time complexity: O(nlongk).
 * Space complexity: O(k).
 */
class Solution {
    /**
     * Use max heap to get the top k smallest elements.
     * Add numbers to max heap, keep the size of heap to k.
     * If size > k, remove the top element.  So the heap always keeps k smallest elements.
     * Return the top in the end, which is the kth largest number.
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}