class Solution {
    // Sort solution
    // N is the size of strs
    // K is the size of each element in strs
    // Time complexity: O(NKlogK)
    // Space complexity: O(NK)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList> result = new HashMap<>();
        for (String s : strs) {
            // Sort string
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }
        return new ArrayList(result.values());
    }
}