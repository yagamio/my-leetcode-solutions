/**
 * 345. Reverse Vowels of a String
 * Two pointers
 * N is the length of string s
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public String reverseVowels(String s) {
        if (s == null) return null;
        char[] charArray = s.toCharArray(); // Turn string to char array
        
        // Create a set of vowels
        HashSet<Character> vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        int l = 0, r = s.length() - 1; // two pointers
        while (l < r) {
            while (l < s.length() && !vowels.contains(s.charAt(l))) {
                l++;
            }
            while (r >= 0 && !vowels.contains(s.charAt(r))) {
                r--;
            }
            if (l < r) {
                charArray[l] = s.charAt(r);
                charArray[r] = s.charAt(l);
                l++;
                r--;
            }
        }
        return new String(charArray);
    }
}