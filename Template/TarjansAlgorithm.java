
/**
 * Problem: Critical Connections in a Network
 */
import java.util.*;

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        if (connections.size() == 0)
            return res;
        List<List<Integer>> adj = new ArrayList<>();
        createAdjacencyList(adj, connections, n);
        findBridges(adj, n, res);
        return res;
    }

    private void createAdjacencyList(List<List<Integer>> adj, List<List<Integer>> connections,
            int n) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            int vert = connections.get(i).get(0);
            int node = connections.get(i).get(1);
            adj.get(vert).add(node);
            adj.get(node).add(vert);
        }
    }

    private void findBridges(List<List<Integer>> adj, int n, List<List<Integer>> res) {
        boolean vis[] = new boolean[n];
        int ins[] = new int[n];
        int low[] = new int[n];
        int timer = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                dfs(i, -1, vis, ins, low, adj, timer, res);
        }
    }

    private void dfs(int node, int parent, boolean vis[], int ins[], int low[], List<List<Integer>> adj, int timer,
            List<List<Integer>> res) {
        vis[node] = true;
        ins[node] = low[node] = timer++;
        for (Integer it : adj.get(node)) {
            if (it == parent)
                continue;
            if (!vis[it]) {
                dfs(it, node, vis, ins, low, adj, timer, res);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] > ins[node]) {
                    res.add(new ArrayList<>(Arrays.asList(it, node)));
                }
            } else {
                low[node] = Math.min(low[node], ins[it]);
            }
        }
    }
}