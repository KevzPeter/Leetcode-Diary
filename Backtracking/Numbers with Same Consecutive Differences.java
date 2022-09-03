class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        helper("", n, k, list);
        int sz = list.size();
        int[] res = new int[sz];
        for (int i = 0; i < sz; i++)
            res[i] = list.get(i);
        return res;
    }

    private void helper(String curr, int n, int k, List<Integer> list) {
        if (n == 0) {
            list.add(Integer.parseInt(curr));
            return;
        }
        StringBuilder sb = new StringBuilder(curr);
        int prevDigit = 0, len = curr.length();
        if (curr.length() > 0)
            prevDigit = curr.charAt(len - 1) - '0';
        for (int i = 0; i <= 9; i++) {
            if (len == 0 && i > 0 || len > 0 && Math.abs(prevDigit - i) == k) {
                sb.append(i);
                helper(sb.toString(), n - 1, k, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}