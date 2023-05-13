// DP
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = questions[i][0];
            int skipQuestions = questions[i][1];
            if (i + skipQuestions + 1 < n) {
                dp[i] += dp[i + skipQuestions + 1];
            }
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }
        return dp[0];
    }
}

// Memoization
class Solution2 {
    public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length];
        return mostPointsHelper(0, questions, memo);
    }

    private static long mostPointsHelper(int idx, int[][] questions, long[] memo) {
        if (idx >= questions.length)
            return 0;
        if (memo[idx] > 0)
            return memo[idx];
        int points = questions[idx][0];
        int skip = questions[idx][1];
        return memo[idx] = Math.max(points + mostPointsHelper(idx + skip + 1, questions, memo),
                mostPointsHelper(idx + 1, questions, memo));
    }
}