class Solution {
    public int scoreOfParentheses(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(0);
            }
            else{
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + Math.max(2 * a, 1));
            }
        }
        return stack.pop();
    }
}