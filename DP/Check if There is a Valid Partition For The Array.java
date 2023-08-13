class Solution {
    public boolean validPartition(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        int n = nums.length;
        Boolean[] dp = new Boolean[n + 1];
        return helper(0, nums, dp);
    }

    private boolean helper(int i, int[] nums, Boolean[] dp) {
        if (i >= nums.length)
            return true;
        if (dp[i] != null)
            return dp[i];
        boolean ans = false;
        if (i <= nums.length - 2 && nums[i] == nums[i + 1]) {
            ans |= helper(i + 2, nums, dp);
        }
        if (i <= nums.length - 3 && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
            ans |= helper(i + 3, nums, dp);
        }
        if (i <= nums.length - 3 && nums[i] == nums[i + 1] - 1 && nums[i + 1] == nums[i + 2] - 1) {
            ans |= helper(i + 3, nums, dp);
        }
        return dp[i] = ans;
    }
}