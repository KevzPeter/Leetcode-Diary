class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxDivScore = 0;
        long ans = Integer.MAX_VALUE;
        for (int div : divisors) {
            int currDivScore = 0;
            for (int num : nums) {
                if (div != 0 && num % div == 0) {
                    currDivScore++;
                }
            }
            if (currDivScore >= maxDivScore) {
                ans = currDivScore == maxDivScore ? Math.min(ans, div) : div;
                maxDivScore = currDivScore;
            }
        }
        return (int) ans;
    }
}