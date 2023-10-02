class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = Integer.MIN_VALUE;
        int n = nums.length;
        int[] negPrefix = new int[n];
        int[] posPrefix = new int[n];
        int[] negSuffix = new int[n];
        int[] posSuffix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] < 0) {
                    negPrefix[i] = nums[i];
                    posPrefix[i] = 0;
                    negSuffix[n - i - 1] = nums[n - i - 1];
                    posSuffix[n - i - 1] = 0;
                } else {
                    negPrefix[i] = 0;
                    posPrefix[i] = nums[i];
                    negSuffix[n - i - 1] = 0;
                    posSuffix[n - i - 1] = nums[n - i - 1];
                }
            } else {
                if (nums[i] < 0) {
                    negPrefix[i] = Math.min(negPrefix[i - 1], nums[i]);
                    posPrefix[i] = posPrefix[i - 1];
                    negSuffix[n - i - 1] = Math.min(negSuffix[n - i], nums[n - i - 1]);
                    posSuffix[n - i - 1] = posSuffix[n - i];
                } else {
                    negPrefix[i] = negPrefix[i - 1];
                    posPrefix[i] = Math.max(posPrefix[i - 1], nums[i]);
                    negSuffix[n - i - 1] = negSuffix[n - i];
                    posSuffix[n - i - 1] = Math.max(posSuffix[n - i], nums[n - i - 1]);
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, (negPrefix[i - 1] - nums[i]) * 1l * negSuffix[i + 1]);
            ans = Math.max(ans, (negPrefix[i - 1] - nums[i]) * 1l * posSuffix[i + 1]);
            ans = Math.max(ans, (posPrefix[i - 1] - nums[i]) * 1l * negSuffix[i + 1]);
            ans = Math.max(ans, (posPrefix[i - 1] - nums[i]) * 1l * posSuffix[i + 1]);
        }
        return ans < 0 ? 0 : ans;
    }
}