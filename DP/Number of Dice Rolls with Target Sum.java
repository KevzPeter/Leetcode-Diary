// Daily Challenge : 2/10/22
class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo = new int[n + 1][target + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return helper(n, k, target, memo);
    }

    private int helper(int n, int k, int target, int[][] memo) {
        if (n == 0 && target == 0)
            return 1;
        if (n == 0 || target < 0)
            return 0;
        if (memo[n][target] != -1)
            return memo[n][target];
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = (ans + helper(n - 1, k, target - i, memo) % MOD) % MOD;
        }
        return memo[n][target] = ans;
    }
}