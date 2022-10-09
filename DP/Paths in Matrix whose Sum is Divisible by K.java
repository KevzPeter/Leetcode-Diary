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