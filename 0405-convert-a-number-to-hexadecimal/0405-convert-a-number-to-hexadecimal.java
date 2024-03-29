/**
 * 405. Convert a Number to Hexadecimal
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public String toHex(int num) {
        char [] map = new char [] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}