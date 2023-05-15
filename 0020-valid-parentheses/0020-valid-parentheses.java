/**
 * 20. Valid Parentheses
 * Stack.
 * N is the length of string.
 * Time complexity: O(N).
 * Space complexity: O(N).
 */
class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '('|| c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}