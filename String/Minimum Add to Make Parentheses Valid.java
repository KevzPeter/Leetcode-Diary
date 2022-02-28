class Solution {
    public int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    ans++;
                else
                    stack.pop();
            }
        }
        ans += stack.size();
        return ans;
    }
}