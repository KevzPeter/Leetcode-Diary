class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int remSum = 0;
        for(int reward : reward2) remSum += reward;
        int[][] dp = new int[]
        return helper(0, reward1, reward2, k, remSum);
    }

    private int helper(int i, int[] reward1, int[] reward2, int k, int remSum) {
        if (i == reward1.length || k == 0) {
            return remSum;
        }
        int pick = reward1[i] + helper(i + 1, reward1, reward2, k - 1, remSum - reward2[i]);
        int notPick = helper(i + 1, reward1, reward2, k, remSum);
        return Math.max(pick, notPick);
    }
}