class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int countOrders(int n) {
        long[] dp = new long[501];
        dp[1] = 1;
        dp[2] = 6;
        for (int i = 3; i <= n; i++) {
            int oddNo = 2 * i - 1;
            int perm = (oddNo * (oddNo + 1)) / 2;
            dp[i] = (dp[i - 1] * perm) % MOD;
        }
        return (int) dp[n];
    }
}