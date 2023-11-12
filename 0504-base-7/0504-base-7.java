/**
 * 504. Base 7
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNegative = num < 0;
        StringBuilder sb = new StringBuilder();
        if (isNegative) {
            num = -num;
        }
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        String result = sb.reverse().toString();
        return isNegative ? "-" + result : result;
    }
}