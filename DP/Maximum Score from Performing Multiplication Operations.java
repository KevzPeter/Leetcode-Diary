// 3D memoized solution
class Solution {
    public int maximumScore(int[] nums, int[] m) {
        int n = nums.length;
        int[][][] memo = new int[m.length + 1][n + 1][m.length + 1];
        for (int[][] _mm : memo) {
            for (int[] _m : _mm) {
                Arrays.fill(_m, Integer.MIN_VALUE);
            }
        }
        return helper(0, nums.length - 1, 0, nums, m, memo);
    }

    private int helper(int start, int end, int i, int[] nums, int[] m, int[][][] memo) {
        if (start > end || i >= m.length)
            return 0;
        if (memo[start][end][i] != Integer.MIN_VALUE)
            return memo[start][end][i];
        int takeStart = nums[start] * m[i] + helper(start + 1, end, i + 1, nums, m, memo);
        int takeEnd = nums[end] * m[i] + helper(start, end - 1, i + 1, nums, m, memo);
        return memo[start][end][i] = Math.max(takeStart, takeEnd);
    }
}

// 2D memoized solution
class Solution {
    int dp(Integer[][] memo, int[] nums, int[] multipliers, int op, int left) {
        // For Right Pointer
        int n = nums.length;
        if (op == multipliers.length) {
            return 0;
        }

        // If already computed, return
        if (memo[op][left] != null) {
            return memo[op][left];
        }

        int l = nums[left] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left + 1);
        int r = nums[(n - 1) - (op - left)] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left);

        return memo[op][left] = Math.max(l, r);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] memo = new Integer[nums.length + 1][multipliers.length + 1];
        // Zero operation done in the beginning
        return dp(memo, nums, multipliers, 0, 0);
    }
}

// 2D DP
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        // For Right Pointer
        int n = nums.length;
        // Number of Operations
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], 0);

        for (int op = m - 1; op >= 0; op--) {
            for (int left = op; left >= 0; left--) {
                dp[op][left] = Math.max(multipliers[op] * nums[left] + dp[op + 1][left + 1],
                        multipliers[op] * nums[n - 1 - (op - left)] + dp[op + 1][left]);
            }
        }

        return dp[0][0];
    }
}