class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums.length == 1)
            return true;
        int n = nums.length;
        Boolean[] dp = new Boolean[n + 1];
        Arrays.fill(dp, null);
        return helper(0, nums, dp);
    }

    private boolean helper(int i, int[] nums, Boolean[] dp) {
        if (i == nums.length - 1)
            return true;
        if (dp[i] != null)
            return dp[i];
        boolean ans = false;
        for (int jump = 1; jump <= nums[i] && (jump + i) < nums.length; jump++) {
            ans |= helper(i + jump, nums, dp);
        }
        return dp[i] = ans;
    }
}