/**
 * 205. Isomorphic Strings
 * HashMap
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        List<Integer> list1 = charToInt(s);
        List<Integer> list2 = charToInt(t);
        for (int i = 0; i < s.length(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> charToInt(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> appeared = new HashMap<>();
        int count = 0;
        for (char x : s.toCharArray()) {
            if (!appeared.containsKey(x)) {
                count++;
                appeared.put(x, count);
                list.add(count);
            } else {
                list.add(appeared.get(x));
            }
        }
        return list;
    }
}