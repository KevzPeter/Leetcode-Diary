class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, n-1, graph, path, res);
        return res;
    }
    private void dfs(int currNode, int endNode, int[][] graph, List<Integer> path, List<List<Integer>> res){
        if(currNode == endNode){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int neighborNode : graph[currNode]){
            path.add(neighborNode);
            dfs(neighborNode, endNode, graph, path, res);
            path.remove(path.size() - 1);
        }
    }
}