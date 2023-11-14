/**
 * 168. Excel Sheet Column Title
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append( (char) (columnNumber % 26 + 'A') );
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}