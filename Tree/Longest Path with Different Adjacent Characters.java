class Solution {
    int maxPath = Integer.MIN_VALUE;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = parent.length;
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 1; i < n; i++){
            adj.get(parent[i]).add(i);
        }
        dfs(adj, s, 0);
        return maxPath;
    }
    private int dfs(List<List<Integer>> adj, String s, int i){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int j : adj.get(i)) {
            int cur = dfs(adj, s, j);
            if (s.charAt(j) != s.charAt(i))
                queue.offer(-cur);
        }
        int big1 = queue.isEmpty() ? 0 : -queue.poll();
        int big2 = queue.isEmpty() ? 0 : -queue.poll();
        maxPath = Math.max(maxPath, big1 + big2 + 1);
        return big1 + 1;
    }
}