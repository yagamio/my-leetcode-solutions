/**
 * 75. Sort Colors
 * Quick sort.
 * n is the length of nums.
 * Time complexity: O(nlogn).
 * Space complexity: O(logn).
 */
class Solution {
    
    public void sortColors(int[] nums) {
        Integer[] boxedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxedNums[i] = nums[i];
        }

        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(boxedNums);

        for (int i = 0; i < boxedNums.length; i++) {
            nums[i] = boxedNums[i];
        }
    }

    public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (l >= h) return;
        int pivot = partition(nums, l, h);
        sort(nums, l, pivot - 1);
        sort(nums, pivot + 1, h);
    }

    protected int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h);
            while (less(v, nums[--j]) && j != l);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
}

    public abstract class Sort<T extends Comparable<T>> {
        
        public abstract void sort(T[] nums);
        
        protected boolean less(T v, T w) {
            return v.compareTo(w) < 0;
        }

        protected void swap(T[] nums, int i, int j) {
            T temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}