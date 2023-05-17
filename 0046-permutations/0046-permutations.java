/**
 * 46. Permutations
 * Backtracking
 * N is the length of nums
 * Time complexity: O(N*N!)
 * Space complexity: O(N)
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int num : nums) {
            visited.put(num, false);
        }
        backtracking(nums, visited, result, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, HashMap<Integer, Boolean> visited, List<List<Integer>> result, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list)); // 避免引用传递
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!visited.get(num)) {
                list.add(num);
                visited.put(num, true);
            backtracking(nums, visited, result, list);
            list.remove(list.size() - 1);
            visited.put(num, false);
            }
        }
    }
}