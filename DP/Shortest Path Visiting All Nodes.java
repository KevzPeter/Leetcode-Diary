class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0)
            return 0;
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        int dp[][] = new int[n + 1][endingMask + 1];
        int shortestPath = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            shortestPath = Math.min(shortestPath, helper(i, endingMask, graph, dp));
        }
        return shortestPath;
    }

    private int helper(int i, int mask, int[][] graph, int[][] dp) {
        if (dp[i][mask] != 0)
            return dp[i][mask];
        if ((mask & (mask - 1)) == 0)
            return 0;
        dp[i][mask] = Integer.MAX_VALUE - 1;
        for (int nei : graph[i]) {
            if ((mask & (1 << nei)) != 0) {
                int alreadyVisited = helper(nei, mask, graph, dp);
                int notVisited = helper(nei, (mask ^ (1 << i)), graph, dp);
                int betterOption = Math.min(alreadyVisited, notVisited);
                dp[i][mask] = Math.min(dp[i][mask], 1 + betterOption);
            }
        }
        return dp[i][mask];
    }
}