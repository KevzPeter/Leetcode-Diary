class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "";
        Stack<String> stack = new Stack();
        for (String cur : path.split("/")) {
            if (cur.equals("..")) {
                if (!stack.empty())
                    stack.pop();
            } else if (cur.length() > 0 && !cur.equals("."))
                stack.push(cur);
        }
        return "/" + String.join("/", stack);
    }
}
