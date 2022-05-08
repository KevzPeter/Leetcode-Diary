// memoized version of lcs, can be optimized, 2 bored 2 do so
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        String srev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[len + 1][len + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return lcs(len - 1, len - 1, s, srev, dp);
    }

    private int lcs(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs(i - 1, j - 1, s1, s2, dp);
        } else {
            return dp[i][j] = Math.max(lcs(i - 1, j, s1, s2, dp),
                    lcs(i, j - 1, s1, s2, dp));
        }
    }
}