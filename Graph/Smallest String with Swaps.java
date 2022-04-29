class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        int n = pairs.size();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> pair : pairs) {
            int u = pair.get(0);
            int v = pair.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[len];
        char[] answer = new char[s.length()];
        for (int i = 0; i < len; i++) {
            if (vis[i] != 1) {
                List<Character> characters = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();

                DFS(s, i, characters, indices, adj, vis);
                // Sort the list of characters and indices
                Collections.sort(characters);
                Collections.sort(indices);

                // Store the sorted characters corresponding to the index
                for (int index = 0; index < characters.size(); index++) {
                    answer[indices.get(index)] = characters.get(index);
                }
            }
        }
        return new String(answer);
    }

    private void DFS(String s, int vertex, List<Character> characters, List<Integer> indices, List<List<Integer>> adj,
            int[] vis) {
        // Add the character and index to the list
        characters.add(s.charAt(vertex));
        indices.add(vertex);

        vis[vertex] = 1;

        // Traverse the adjacents
        for (int adjacent : adj.get(vertex)) {
            if (vis[adjacent] != 1) {
                DFS(s, adjacent, characters, indices, adj, vis);
            }
        }
    }
}