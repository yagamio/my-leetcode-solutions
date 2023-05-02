/**
 * 75. Sort Colors
 * Merge sort.
 * n is the length of nums.
 * Time complexity: O(nlogn).
 * Space complexity: O(n).
 */
class Solution {
    
    public void sortColors(int[] nums) {
        Integer[] boxedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxedNums[i] = nums[i];
        }
        upToDownMerge<Integer> sorter = new upToDownMerge<Integer>();
        sorter.sort(boxedNums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }
    }

    public class upToDownMerge<T extends Comparable<T>> extends mergeSort<T> {
        
        @Override
        public void sort(T[] nums) {
            aux = (T[]) new Comparable[nums.length];
            sort(nums, 0, nums.length - 1);
        }

        protected void sort(T[] nums, int l, int h) {
            if (l >= h) return;
            int mid = l + (h - l) / 2;
            sort(nums, l, mid);
            sort(nums, mid + 1, h);
            merge(nums, l, mid, h);
        }

    }

    public abstract class mergeSort<T extends Comparable<T>> extends sort<T> {
        
        protected T[] aux;

        protected void merge(T[] nums, int l, int m, int h) {
            int i = l, j = m + 1;
            for (int k = l; k <= h; k++) {
                aux[k] = nums[k];
            }
            for (int k = l; k <= h; k++) {
                if (i > m) {
                    nums[k] = aux[j++];
                } else if (j > h) {
                    nums[k] = aux[i++];
                } else if (aux[i].compareTo(aux[j]) <= 0) {
                    nums[k] = aux[i++];
                } else {
                    nums[k] = aux[j++];
                }
            }
        }

    }

    public abstract class sort<T extends Comparable<T>> {

        public abstract void sort(T[] nums);

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