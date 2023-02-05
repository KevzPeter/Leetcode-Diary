import java.util.*;

class Solution {
    private class Player {
        int score;
        int age;

        Player(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(scores[i], ages[i]);
        }
        int[][] dp = new int[n + 1][1001];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        Arrays.sort(players, (Player a, Player b) -> b.score == a.score ? b.age - a.age : b.score - a.score);
        return helper(0, players, null, null, dp);
    }

    private int helper(int i, Player[] players, Integer minAge, Integer prevScore, int[][] dp) {
        if (i == players.length)
            return 0;
        if (minAge != null && dp[i][minAge] != -1)
            return dp[i][minAge];
        int pick = 0, notPick = 0;
        if (minAge == null || players[i].age <= minAge || players[i].score == prevScore) {
            pick = players[i].score + helper(i + 1, players, players[i].age, players[i].score, dp);
        }
        notPick = helper(i + 1, players, minAge, prevScore, dp);
        int ans = Math.max(pick, notPick);
        if (minAge != null)
            dp[i][minAge] = ans;
        return ans;
    }
}