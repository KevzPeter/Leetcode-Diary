class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[21][40_001];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(0, nums, target, dp);
    }

    private int helper(int i, int[] nums, int target, int[][] dp) {
        if (target == 0 && i == nums.length) {
            return 1;
        }
        if (i >= nums.length)
            return 0;
        if (dp[i][target + 20_000] != -1)
            return dp[i][target + 20_000];
        int takePos = helper(i + 1, nums, target - nums[i], dp);
        int takeNeg = helper(i + 1, nums, target + nums[i], dp);
        return dp[i][target + 20_000] = (takePos + takeNeg);
    }
}