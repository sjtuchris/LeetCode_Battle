class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')' && s.charAt(stack.peek())) {
                stack.pop();
            }
        }
        if (stack.empty()) return s.length();
                int a = s.length() - 1;
                int b = 0;
                int res = 0;
                while (!stack.empty()) {
                    b = stack.pop();
            res = max(res, a - b);
            a = b - 1;
        }
        return res;
    }
}