/**
 * 75. Sort Colors
 * Shell.
 * n is the length of nums.
 * Time complexity: O(n^(4/3)).
 * Space complexity: O(1).
 */
class Solution {
    
    public void sortColors(int[] nums) {
        Integer[] boxedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxedNums[i] = nums[i];
        }
        Shell sorter = new Shell<Integer>();
        sorter.sort(boxedNums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }
    }

    public class Shell<T extends Comparable<T>> extends sort<T> {

        @Override
        public void sort(T[] nums) {
            int N = nums.length;
            int h = 1;
            while (h < N / 3) {
                h = 3 * h + 1;
            }
            while (h >= 1) {
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                        swap(nums, j, j - h);
                    }
                }
                h = h / 3;
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