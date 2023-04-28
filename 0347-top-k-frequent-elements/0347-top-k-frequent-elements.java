class Solution {
    /**
     * 347. Top K Frequent Elements
     * 桶排序 Bucket sort.
     * 将数组中数字出现的频率作为桶的标签，将相同频率的数放入同一个桶中。
     * 标签的范围就是频率范围，即为[0，nums.length]。初始化时直接按频率排好序了。
     * 根据题意需要，反向遍历，从第一个不为空的桶开始，取出k个元素。
     * n is the size of nums.
     * Time complexity: O(n).
     * Space complexity: O(n + n + k).
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 为结果集开辟空间
        int[] result = new int[k];
        // 新建字典，将全部数放入，数字为key，频率为value
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int num : nums) {
            dict.put(num, dict.getOrDefault(num, 0) + 1);
        }
        // 新建数组，为桶开辟空间
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        // 将数放入桶中，如果数组中还没桶，就新建一个桶
        for (int num : dict.keySet()) { //注意这里不能用num : nums，因为会重复
            int freq = dict.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        // 遍历桶数组，反向取出k个元素，即为频率最大的k个
        // 声明几个变量，t用来遍历桶数组，j用来遍历桶，i用来将数加入结果集
        int i = 0, t, j;
        for (t = nums.length; t > 0; --t) {
            if (bucket[t] != null) {
                for (j = 0; j < bucket[t].size() && i < k; ++j) {
                    result[i++] = bucket[t].get(j);
                }
            }
        }
        return result;
    }
}