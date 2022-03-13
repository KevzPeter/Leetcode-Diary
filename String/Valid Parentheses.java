class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0) return false;
        
        Stack<Character> stack =  new Stack<>();
        char chars[] = s.toCharArray();
        for(char c : chars){
            if(c=='(' || c=='{' || c=='[')
                stack.push(c);
            else if(c==')'){
                if(stack.isEmpty() || stack.peek()!='(') return false;
                stack.pop();
            }
            else if(c=='}'){
                if(stack.isEmpty() || stack.peek()!='{') return false;
                stack.pop();
            }
            else if(c==']'){
                if(stack.isEmpty() || stack.peek()!='[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}