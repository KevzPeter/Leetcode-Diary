//Weekly contest 314, Q4 (Hard), Memoized solution
class Solution {
    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 } };
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] memo = new int[m][n][k];
        for (int[][] mem : memo) {
            for (int[] me : mem)
                Arrays.fill(me, -1);
        }
        return helper(0, 0, grid, m, n, k, 0, memo);
    }

    private int helper(int i, int j, int[][] grid, int m, int n, int k, int currSum, int[][][] memo) {
        if (!isValid(i, j, m, n))
            return 0;
        currSum = ((currSum + grid[i][j]) % k);
        if (memo[i][j][currSum] != -1)
            return memo[i][j][currSum];
        if (i == m - 1 && j == n - 1) {
            if (currSum % k == 0)
                return 1;
            return 0;
        }
        int ans = 0;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            ans = (ans + (helper(x, y, grid, m, n, k, currSum, memo) % MOD)) % MOD;
        }
        return memo[i][j][currSum] = ans;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}

// Bottom up (3D) DP solution
class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, mod = 1000_000_007;
        int[][][] dp = new int[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int s = 0; s < k; s++) {
                    int moddedSum = (s + grid[i][j]) % k;
                    if (j > 0)
                        dp[i][j][moddedSum] += dp[i][j - 1][s];
                    if (i > 0)
                        dp[i][j][moddedSum] += dp[i - 1][j][s];
                    dp[i][j][moddedSum] %= mod;
                }
        return dp[m - 1][n - 1][0];
    }
}