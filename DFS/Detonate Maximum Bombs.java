class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<Integer>[] adj = new List[bombs.length];

        for (int i = 0; i < bombs.length; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < bombs.length - 1; i++)// generate every pair
            for (int j = i + 1; j < bombs.length; j++) {
                long dist = dist(bombs[i], bombs[j]);// distance between the bombs
                if (dist <= 1l * bombs[i][2] * bombs[i][2])
                    adj[i].add(j);// make a edge from i to j

                if (dist <= 1l * bombs[j][2] * bombs[j][2])
                    adj[j].add(i);// make a edge from j to i
            }
        int res = 0;

        for (int i = 0; i < bombs.length; i++) // count the exploded bombs for every bomb explosion
            res = Math.max(res, dfs(adj, i, new boolean[bombs.length]));

        return res;
    }

    private int dfs(List<Integer>[] adj, int src, boolean[] vis) {// traverse graph
        if (vis[src])
            return 0;

        int res = 1;
        vis[src] = true;

        for (int next : adj[src])
            res += dfs(adj, next, vis);

        return res;
    }

    private long dist(int[] p1, int[] p2) {// distance formula
        return 1l * (p1[0] - p2[0]) * (p1[0] - p2[0]) + 1l * (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}