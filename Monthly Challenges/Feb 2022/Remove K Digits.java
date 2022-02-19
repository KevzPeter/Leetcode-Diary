//18-02-2022
class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0) return "";
        else if(k == 0) return num;
        else if(k == num.length()) return "0";
        int n = num.length();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while(i<n){
            char curr = num.charAt(i);
            while(k > 0 && !stack.isEmpty() && stack.peek() > curr){
                stack.pop();
                k--;
            }
            stack.push(curr);
            i++;
        }
        // for cases where all digits are the same, eg : "1111"
        while(k-- > 0)
             stack.pop();

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())
            res.append(stack.pop());
        res.reverse();
        
        //remove all the 0 at the head
        while(res.length()>1 && res.charAt(0)=='0')
            res.deleteCharAt(0);
        
        return res.toString();
    }
}