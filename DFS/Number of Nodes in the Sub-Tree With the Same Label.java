class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(0, adj, labels, ans, new int[26], new boolean[n]);
        return ans;
    }

    private int[] dfs(int curr, List<List<Integer>> adj, String labels, int[] ans, int[] count,
            boolean[] vis) {
        vis[curr] = true;
        char currLabel = labels.charAt(curr);
        count[currLabel - 'a']++;
        for (int nei : adj.get(curr)) {
            if (!vis[nei]) {
                int[] countChild = new int[26];
                int[] res = dfs(nei, adj, labels, ans, countChild, vis);
                for (int i = 0; i < 26; i++) {
                    count[i] += res[i];
                }
            }
        }
        ans[curr] = count[currLabel - 'a'];
        return count;
    }
}