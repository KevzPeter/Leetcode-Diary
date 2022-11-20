class Solution {
    long ans = 0;
    int s;

    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads == null || roads.length == 0 || seats == 0)
            return 0;
        s = seats;
        List<List<Integer>> graph = new ArrayList<>();
        int n = roads.length;

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        dfs(0, 0, graph);
        return ans;
    }

    private int dfs(int i, int prev, List<List<Integer>> graph) {
        int people = 1;
        for (int x : graph.get(i)) {
            if (x == prev)
                continue;
            people += dfs(x, i, graph);
        }
        if (i != 0)
            ans += (people + s - 1) / s;
        return people;
    }
}