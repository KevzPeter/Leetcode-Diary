/**
 * Two strings X and Y are similar if we can swap two letters (in different
 * positions) of X, so that it equals Y. Also two strings X and Y are similar if
 * they are equal.
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2),
 * and "rats" and "arts" are similar, but "star" is not similar to "tars",
 * "rats", or "arts".
 * Together, these form two connected groups by similarity: {"tars", "rats",
 * "arts"} and {"star"}. Notice that "tars" and "arts" are in the same group
 * even though they are not similar. Formally, each group is such that a word is
 * in the group if and only if it is similar to at least one other word in the
 * group.
 * We are given a list strs of strings where every string in strs is an anagram
 * of every other string in strs. How many groups are there?
 */
class Solution {
    public int numSimilarGroups(String[] strs) {
        List<List<Integer>> adj = new ArrayList<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            char[] currWord = strs[i].toCharArray();
            for (int j = i + 1; j < len; j++) {
                char[] nextWord = strs[j].toCharArray();
                int notMatch = 0;
                if (currWord.length != nextWord.length)
                    continue;
                for (int k = 0; k < currWord.length; k++) {
                    if (currWord[k] != nextWord[k]) {
                        notMatch++;
                    }
                }
                if (notMatch <= 2) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int similarGroups = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                ++similarGroups;
                dfs(i, adj, visited);
            }
        }
        return similarGroups;
    }

    private void dfs(int curr, List<List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;
        for (int nei : adj.get(curr)) {
            if (!visited[nei]) {
                dfs(nei, adj, visited);
            }
        }
    }
}