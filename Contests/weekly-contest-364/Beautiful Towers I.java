class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long maxSum = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            int peakValue = maxHeights.get(i);
            long currSum = peakValue;
            int prevHeight = peakValue;

            for (int j = i - 1; j >= 0; j--) {
                int currHeight = maxHeights.get(j);
                int minHeight = Math.min(currHeight, prevHeight);
                currSum += minHeight;
                prevHeight = minHeight;
            }

            prevHeight = peakValue;
            for (int k = i + 1; k < maxHeights.size(); k++) {
                int currHeight = maxHeights.get(k);
                int minHeight = Math.min(currHeight, prevHeight);
                currSum += minHeight;
                prevHeight = minHeight;
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}