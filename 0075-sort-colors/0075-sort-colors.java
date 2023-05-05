/**
 * 75. Sort Colors
 * Three way quick sort.
 * n is the size of nums.
 * Time complexity: O(n) - O(nlogn).
 * Space complexity: O(1).
 */
class Solution {
    public void sortColors(int[] nums) {
        Integer[] boxedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxedNums[i] = nums[i];
        }
        threeWayQuickSort sorter = new threeWayQuickSort<>();
        sorter.sort(boxedNums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }
    }

    public class threeWayQuickSort<T extends Comparable<T>> extends sort<T> {
        @Override
        public void sort(T[] nums) {
            sort(nums, 0, nums.length - 1);
        }
        
        protected void sort(T[] nums, int l, int h) {
            if (h <= l) return;
            // 定义三个指针
            int lt = l, i = l + 1, gt = h;
            // 取第一个数作为基准
            T v = nums[l];
            while (i <= gt) {
                int compare = nums[i].compareTo(v);
                if (compare == 0) {
                    i++;
                } else if (compare > 0) {
                    swap(nums, i, gt--);
                } else {
                    swap(nums, i++, lt++);
                }
            }
            sort(nums, l, lt - 1);
            sort(nums, gt + 1, h);
        }
    }

    public abstract class sort<T extends Comparable<T>> {
        public void sort(T[] nums){};

        protected boolean less(T v, T w) {
            return v.compareTo(w) < 0;
        }

        protected void swap(T[] a, int i, int j) {
            T t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}