/**
 * 744. Find Smallest Letter Greater Than Target
 * Binary search. Blue and Red method
 * N is the length of char[] letters
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        if (letters[len - 1] <= target) {
            return letters[0];
        }
        int left = -1;
        int right = len;
        while (left + 1 != right) {
            int mid = left + ((right - left) >> 1);
            if (letters[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return letters[right];
    }
}