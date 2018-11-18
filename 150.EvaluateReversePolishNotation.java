class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int i = Integer.parseInt(stack.pop());
                int j = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(j+i));
            } else if (token.equals("-")) {
                int i = Integer.parseInt(stack.pop());
                int j = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(j-i));
            } else if (token.equals("*")) {
                int i = Integer.parseInt(stack.pop());
                int j = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(j*i));
            } else if (token.equals("/")) {
                int i = Integer.parseInt(stack.pop());
                int j = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(j/i));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}