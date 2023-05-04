/**
 * 75. Sort Colors
 * Insertion sort.
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
        insertionSort sorter = new insertionSort<Integer>();
        sorter.sort(boxedNums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }
    }

    public class insertionSort<T extends Comparable<T>> extends sort<T> {

        @Override
        public void sort(T[] nums) {
            int N = nums.length;
            //遍历数组，将每个元素和前面已排序的小数组比较，如果当前值较小则交换
            for (int i = 1; i < N; i++) {
                for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                    swap(nums, j, j - 1);
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