class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>(n);
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }
        createGraph(graph, edges);
        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            dfs(i, graph, vis, ans, i);
        }
        return ans;
    }

    private void dfs(int i, List<List<Integer>> graph, boolean[] vis, List<List<Integer>> ans, int j) {
        vis[j] = true;
        for (int nei : graph.get(j)) {
            if (!vis[nei]) {
                ans.get(nei).add(i);
                dfs(i, graph, vis, ans, nei);
            }

        }
    }

    private void createGraph(List<List<Integer>> graph, int[][] edges) {
        for (int[] edge : edges) {
            int node = edge[0];
            int nei = edge[1];
            graph.get(node).add(nei);
        }
    }
}
