class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1)
                take += dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n - 1];
    }
}
/*
 * class Solution {
 * public int rob(int[] nums) {
 * int n = nums.length;
 * return helper(n-1, nums);
 * }
 * private int helper(int i, int[] nums){
 * if(i == 0) return nums[0];
 * if(i < 0) return 0;
 * int pick = nums[i] + helper(i - 2, nums);
 * int notPick = helper(i - 1, nums);
 * return Math.max(pick, notPick);
 * }
 * }
 */