class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] memo = new long[n][2];
        for (long[] m : memo) {
            Arrays.fill(m, Long.MAX_VALUE);
        }
        return helper(0, nums[0], nums, x, memo);
    }

    private long helper(int i, int prev, int[] nums, int x, long[][] memo) {
        if (i == nums.length)
            return 0;
        if (i == 0)
            return nums[0] + helper(1, 0, nums, x, memo);
        if (memo[i][nums[prev] % 2] != Long.MAX_VALUE)
            return memo[i][nums[prev] % 2];
        long pick = 0, notPick = 0;
        if (nums[prev] % 2 == nums[i] % 2) {
            pick = nums[i] + helper(i + 1, i, nums, x, memo);
        } else {
            pick = nums[i] - x + helper(i + 1, i, nums, x, memo);
        }
        notPick = helper(i + 1, prev, nums, x, memo);
        return memo[i][nums[prev] % 2] = Math.max(pick, notPick);
    }
}