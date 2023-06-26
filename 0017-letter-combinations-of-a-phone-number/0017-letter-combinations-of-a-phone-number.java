/**
 * 17. Letter Combinations of a Phone Number
 * Backtracking
 * M is the number of letters for each digit
 * N is the length of String digits
 * Time complexity: O(M ^ N)
 * Space complexity: O(M ^ N)
 */
class Solution {

    private static final Map<Character, String> phoneMap = initPhoneMap();

    private static Map<Character, String> initPhoneMap() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination(0, new StringBuilder(), combinations, phoneMap, digits);
        return combinations;
    }

    private void doCombination(int index, StringBuilder combo, List<String> combinations, Map<Character, String> phoneMap, String digits) {
        if (index == digits.length()) { // means that in the last DFS, index == digits.lenght() - 1
            combinations.add(combo.toString());
            return;
        }
        // index points to the current digit to do combination
        char currentDigit = digits.charAt(index);
        String letters = phoneMap.get(currentDigit);
        for (int i = 0; i < letters.length(); i++) {
            combo.append(letters.charAt(i));
            doCombination(index + 1, combo, combinations, phoneMap, digits);
            combo.deleteCharAt(combo.length() - 1);
        }
    }
}