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
        dfs(0, -1, adj, labels, ans, new int[26]);
        return ans;
    }

    private int[] dfs(int currNode, int parent, List<List<Integer>> adj, String labels, int[] ans, int[] count) {
        char currLabel = labels.charAt(currNode);
        count[currLabel - 'a']++;
        for (int child : adj.get(currNode)) {
            if(child == parent) continue;
            else{
                int[] countChild = new int[26];
                int[] res = dfs(child, currNode, adj, labels, ans, countChild);
                for (int i = 0; i < 26; i++) {
                    count[i] += res[i];
                }
            }
        }
        ans[currNode] = count[currLabel - 'a'];
        return count;
    }
}