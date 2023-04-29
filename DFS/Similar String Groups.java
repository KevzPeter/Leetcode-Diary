class Solution {
    public int numSimilarGroups(String[] strs) {
        List<List<Integer>> adj = new ArrayList<>();
        int len = strs.length;
        for(int i = 0; i < len; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < len; i++){
            char[] currWord = strs[i].toCharArray();
            for(int j = i + 1; j < len; j++){
                char[] nextWord = strs[j].toCharArray();
                int notMatch = 0;
                if(currWord.length != nextWord.length) continue;
                for(int k = 0; k < currWord.length; k++){
                    if(currWord[k] != nextWord[k]){
                        notMatch++;
                    }
                }
                if(notMatch <= 2){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int similarGroups = 0;
        boolean[] visited = new boolean[len];
        for(int i = 0; i < len; i++){
            if(!visited[i]){
                ++similarGroups;
                dfs(i, adj, visited);
            }
        }
        return similarGroups;
    }
    private void dfs(int curr, List<List<Integer>> adj, boolean[] visited){
        visited[curr] = true;
        for(int nei : adj.get(curr)){
            if(!visited[nei]){
                dfs(nei, adj, visited);
            }
        }
    }
}