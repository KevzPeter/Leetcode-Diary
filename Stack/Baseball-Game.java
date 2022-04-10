class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("+")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int n3 = n1 + n2;
                stack.push(n2);
                stack.push(n1);
                stack.push(n3);
            } else if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                int n = stack.pop();
                int nx2 = n * 2;
                stack.push(n);
                stack.push(nx2);
            } else {
                int num = Integer.parseInt(s);
                stack.push(num);
            }
        }
        int record = 0;
        for (Integer i : stack) {
            record += i;
        }
        return record;
    }
}