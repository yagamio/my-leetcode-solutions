/**
 * 241. Different Ways to Add Parentheses
 * Divide and conquer. Recursion.
 * Time complexity:
 * Space complexity:
 */
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // create space for result
        List<Integer> ways = new ArrayList<>();
        int len = expression.length();
        
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int p : left) {
                    for (int q : right) {
                        switch (c) {
                            case '+':
                                ways.add(p + q);
                                break;
                            case '-':
                                ways.add(p - q);
                                break;
                            case '*':
                                ways.add(p * q);
                                break;
                        }
                    }
                }
            }
        }
        
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(expression));
        }
        
        return ways;
    }
}