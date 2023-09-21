/**
 * 20. Valid Parentheses
 * Stack
 * N is the length of string s
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char a : s.toCharArray()) {
            if (a == '(' || a == '[' || a == '{') {
                stack.push(a);
            } else if (stack.isEmpty()) {
                return false;
            } else if (a == ')') {
                if (stack.pop() != '(') return false;
            } else if (a == ']') {
                if (stack.pop() != '[') return false;
            } else if (a == '}') {
                if (stack.pop() != '{') return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}