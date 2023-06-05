/**
 * 524. Longest Word in Dictionary through Deleting
 * Two pointers
 * N is the number of strings in array. M is the average length of them.
 * Time complexity: O(M * N)
 * Space complexity: O(1)
 */

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (String target : dictionary) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l2 < l1 || (l2 == l1 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubString(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isSubString(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}