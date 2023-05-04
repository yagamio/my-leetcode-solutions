/**
 * 75. Sort Colors
 * Bubble sort.
 * n is the length of nums.
 * Time complexity: O(n^2).
 * Space complexity: O(1).
 */
class Solution {
    
    public void sortColors(int[] nums) {
        Integer[] boxedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxedNums[i] = nums[i];
        }
        bubbleSort sorter = new bubbleSort<Integer>();
        sorter.sort(boxedNums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }
    }

    public class bubbleSort<T extends Comparable<T>> extends sort<T> {

        @Override
        public void sort(T[] nums) {
            boolean isSorted = false;
            int N = nums.length;
            for (int i = N - 1; i > 0 && !isSorted; i--) {
                isSorted = true;
                for (int j = 0; j < i; j++) {
                    if (less(nums[j + 1], nums[j])) {
                        isSorted = false;
                        swap(nums, j, j + 1);
                    }
                }
            }
        }
    }

    public abstract class sort<T extends Comparable<T>> {
        
        public void sort(T[] nums) {};

        public boolean less(T v, T w) {
            return v.compareTo(w) < 0;
        }

        public void swap(T[] a, int i, int j) {
            T t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

    }
}