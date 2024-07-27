class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] costMatrix = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j)
                    costMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
        int len = original.length;
        Map<Character, List<Pair<Character, Integer>>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char node = original[i];
            if (!map.containsKey(node)) {
                map.put(node, new ArrayList<>());
            }
            char nei = changed[i];
            int c = cost[i];
            map.get(node).add(new Pair(nei, c));
        }
        for (int i = 0; i < 26; i++) {
            char curr = (char) (i + 'a');
            dfs(curr, curr, map, new boolean[26], 0, costMatrix);
        }
        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            int src = source.charAt(i) - 'a';
            int dest = target.charAt(i) - 'a';
            if (costMatrix[src][dest] == Integer.MAX_VALUE) {
                return -1;
            }
            ans += costMatrix[src][dest];
        }
        return ans;
    }

    private void dfs(char parent, char curr, Map<Character, List<Pair<Character, Integer>>> map, boolean[] visited,
            int totalCost, int[][] costMatrix) {
        visited[curr - 'a'] = true;
        int parentIdx = parent - 'a';
        if (map.containsKey(curr)) {
            for (Pair<Character, Integer> p : map.get(curr)) {
                char nei = p.getKey();
                int cost = p.getValue();
                int neiIdx = nei - 'a';
                if (!visited[neiIdx] || (visited[neiIdx] && totalCost + cost < costMatrix[parentIdx][neiIdx])) {
                    costMatrix[parentIdx][neiIdx] = Math.min(costMatrix[parentIdx][neiIdx],
                            totalCost + cost);
                    dfs(parent, nei, map, visited, totalCost + cost, costMatrix);
                }
            }
        }
    }
}