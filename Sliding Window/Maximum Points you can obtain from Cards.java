class Solution {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0)
            return 0;
        int n = cardPoints.length;
        int[] prefixSum = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0)
                prefixSum[i] = cardPoints[i];
            else
                prefixSum[i] = prefixSum[i - 1] + cardPoints[i];
        }

        int totalScore = prefixSum[n - 1];
        if (k == n)
            return totalScore;

        int start = 0;
        int end = n - k - 1;
        int maxScore = 0;

        while (end < n) {
            int currWindowScore = 0;
            if (start == 0)
                currWindowScore = prefixSum[end];
            else
                currWindowScore = prefixSum[end] - prefixSum[start - 1];
            maxScore = Math.max(maxScore, totalScore - currWindowScore);
            start++;
            end++;
        }

        return maxScore;
    }
}