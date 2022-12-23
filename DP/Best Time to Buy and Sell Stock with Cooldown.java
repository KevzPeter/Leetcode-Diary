class Solution {
    // buy = 0, sell = 1, cooldown = 2
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        return helper(0, prices, dp, 2);
    }

    private int helper(int i, int[] prices, int[][] dp, int lastAction) {
        if (i == prices.length)
            return 0;
        if (dp[i][lastAction] != Integer.MIN_VALUE)
            return dp[i][lastAction];
        int ans = 0;
        if (lastAction == 0) {
            ans = Math.max(prices[i] + helper(i + 1, prices, dp, 1),
                    helper(i + 1, prices, dp, 0));
        }
        if (lastAction == 1) {
            ans = helper(i + 1, prices, dp, 2);
        }
        if (lastAction == 2) {
            ans = Math.max(helper(i + 1, prices, dp, 0) - prices[i],
                    helper(i + 1, prices, dp, 2));
        }
        return dp[i][lastAction] = ans;
    }
}