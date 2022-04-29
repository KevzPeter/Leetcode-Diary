class Solution {
    boolean ans = true;
    public boolean isBipartite(int[][] graph) {
        boolean prevColor = false;
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] color = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, vis, graph, color, prevColor);
            }
        }
        return ans;
    }
    private void dfs(int i, boolean[] vis, int[][] graph, boolean[] color, boolean prevColor){
        boolean nextColor = !prevColor;
        color[i] = nextColor;
        vis[i] = true;
        for(int it : graph[i]){
            if(!vis[it]){
                dfs(it, vis, graph, color, nextColor);
            }
            else if(color[it] == nextColor){
                ans = ans && false;
                return;
            }
        }
    }
}