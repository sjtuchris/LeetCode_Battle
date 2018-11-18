class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {            
            char bracket = s.charAt(i);
            if (bracket == '(') {
                stack.push(')');
            } else if (bracket == '[') {
                stack.push(']');
            } else if (bracket == '{') {
                stack.push('}');
            } else if (stack.empty() || stack.peek() != bracket) {
                return false;
            } else {
                stack.pop();
            }
           
        }        
        return stack.empty();
    }
}