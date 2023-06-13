/**
 * 763. Partition Labels
 * Greedy. Hash map.
 * N is the length of String s
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        // create a hash table to store letters and their start and end index in string
        HashMap<Character, List<Integer>> letters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!letters.containsKey(cur)) {
                letters.put(cur, new ArrayList<>());
                letters.get(cur).addAll(Arrays.asList(i, i));
            } else {
                letters.get(cur).set(1, i);
            }
        }
        // create a list of intervals to store partitions by index
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(letters.get(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> cur = letters.get(c);
            List<Integer> target = intervals.get(intervals.size() - 1);
            if (cur.get(0) <= target.get(1)) {
                // ps. update the end to the bigger value
                target.set(1, Math.max(target.get(1), cur.get(1)));
            } else {
                intervals.add(cur);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (List<Integer> interval : intervals) {
            int length = interval.get(1) - interval.get(0) + 1;
            result.add(length);
        }
        return result;
    }
}