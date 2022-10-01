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
        // substring starting with 0 is not a valid encoding
        if (c == '0') {
            return 0;
        }
        // if it starts with 1 or 2, we can take two characters at the same time if it
        // fulfills the conditions
        else if (i < len - 1 && (c == '1' || (c == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'))) {
            ans += helper(i + 2, s, memo);
        }
        // taking a single character at a time
        ans += helper(i + 1, s, memo);
        return memo[i] = ans;
    }
}