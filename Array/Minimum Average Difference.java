class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] sumLeft = new long[n];
        long[] sumRight = new long[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumLeft[i] = nums[i];
                sumRight[n - i - 1] = nums[n - i - 1];
            } else {
                sumLeft[i] = sumLeft[i - 1] + nums[i];
                sumRight[n - i - 1] = sumRight[n - i] + nums[n - i - 1];
            }
        }
        int minAvg = Integer.MAX_VALUE;
        int minIdx = n;
        for (int i = 0; i < n; i++) {
            int leftAvg = (int) (sumLeft[i] / (i + 1));
            int rightAvg = 0;
            if (i < n - 1)
                rightAvg = (int) (sumRight[i + 1] / (n - i - 1));
            int currAvg = Math.abs(leftAvg - rightAvg);
            if (currAvg < minAvg) {
                minAvg = currAvg;
                minIdx = i;
            }
        }

        return minIdx;
    }
}