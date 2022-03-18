// 15-03-2022
class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return s;
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c == '(') {
                sb.append(c);
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    sb.append(c);
                    stack.pop();
                }
            }
        }
        int end = sb.length() - 1;
        while (!stack.isEmpty()) {
            while (end >= 0 && sb.charAt(end) != '(') {
                end--;
            }
            sb.deleteCharAt(end--);
            stack.pop();
        }
        return sb.toString();
    }
}