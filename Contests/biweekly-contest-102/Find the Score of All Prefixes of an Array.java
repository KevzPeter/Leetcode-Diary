class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        int[] maxPrefix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                maxPrefix[i] = nums[i];
            else {
                maxPrefix[i] = Math.max(nums[i], maxPrefix[i - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0)
                ans[i] = (1l * nums[i]) + nums[i];
            else {
                ans[i] = (1l * nums[i]) + maxPrefix[i] + ans[i - 1];
            }
        }
        return ans;
    }
}