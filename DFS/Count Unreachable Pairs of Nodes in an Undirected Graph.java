class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }   
        long visitedNodes = 0;
        long ans = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                int nodesInComponent = dfs(i, adj, visited);
                ans += visitedNodes * nodesInComponent;
                visitedNodes += nodesInComponent;
            }
        }
        return ans;
    }
    private int dfs(int currNode, List<List<Integer>> adj, boolean[] visited){
        visited[currNode] = true;
        int nodes = 1;
        for(int neighborNode : adj.get(currNode)){
            if(!visited[neighborNode]){
                nodes += dfs(neighborNode, adj, visited);
            }
        }
        return nodes;
    }
}