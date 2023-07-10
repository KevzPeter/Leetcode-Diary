class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return helper(0, 0, nums, target, memo);
    }

    private int helper(int i, int last, int[] nums, int target, int[] memo) {
        if (i == nums.length - 1) {
            return 0;
        }
        if (memo[i] != Integer.MIN_VALUE)
            return memo[i];
        int ans = -1;
        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[j] - nums[i]) <= target) {
                int t = helper(j, nums[j], nums, target, memo);
                if (t != -1)
                    ans = Math.max(ans, t + 1);
            }
        }
        return memo[i] = ans;
    }
}