class Solution {
    int globalTime;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        Map<Integer, Integer> bobTime = new HashMap<>();
        bobSearch(bob, adj, bobTime);
        return aliceSearch(0, adj, bobTime, new boolean[n + 1], 0, amount);
    }

    private void bobSearch(int bob, List<List<Integer>> adj, Map<Integer, Integer> bobTime) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        boolean[] visited = new boolean[adj.size()];

        q.offer(bob);
        visited[bob] = true;
        parent.put(bob, -1);

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == 0)
                break;

            for (int nei : adj.get(curr)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                    parent.put(nei, curr);
                }
            }
        }

        int currTime = 0;
        int node = 0;
        while (node != -1) {
            bobTime.put(node, currTime);
            node = parent.get(node);
            currTime++;
        }
        globalTime = currTime - 1;
    }

    private int aliceSearch(int curr, List<List<Integer>> adj, Map<Integer, Integer> bobTime, boolean[] visited,
            int currTime, int[] amount) {
        visited[curr] = true;
        int totalCost = 0;
        if (bobTime.get(curr) == null || currTime < (globalTime - bobTime.get(curr))) {
            totalCost += amount[curr];
        } else if ((globalTime - bobTime.get(curr)) == currTime) {
            totalCost += (amount[curr] / 2);
        }
        int neiCost = Integer.MIN_VALUE;
        for (int nei : adj.get(curr)) {
            if (!visited[nei]) {
                neiCost = Math.max(neiCost, aliceSearch(nei, adj, bobTime, visited, currTime + 1, amount));
            }
        }
        return totalCost + (neiCost == Integer.MIN_VALUE ? 0 : neiCost);
    }
}