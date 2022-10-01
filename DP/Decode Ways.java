// daily challenge : 1/10/22
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return helper(0, s, memo);
    }

    private int helper(int i, String s, int[] memo) {
        int len = s.length();
        if (i == len)
            return 1;
        if (memo[i] != -1)
            return memo[i];
        char c = s.charAt(i);
        int ans = 0;
        if (c == '0') {
            return 0;
        } else if (c == '1' && i < len - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
            ans += helper(i + 2, s, memo);
        } else if (c == '2' && i < len - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6') {
            ans += helper(i + 2, s, memo);
        }
        ans += helper(i + 1, s, memo);
        return memo[i] = ans;
    }
}