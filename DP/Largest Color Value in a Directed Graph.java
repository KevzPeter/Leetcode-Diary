import java.util.Queue;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        // 1. Build the adjacency list and Indegree array
        List<List<Integer>> adj = new ArrayList<>();
        int n = colors.length();
        char[] color = colors.toCharArray();

        for (int i = 0; i < n; i++)
            adj.add(i, new ArrayList<>());

        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[v]++;
            adj.get(u).add(v);
        }

        // 2. color count map. map[i][j] is the maximum count of j-th color from the
        // ancestor nodes to node i
        int[][] map = new int[n][26];

        // 3.Khans Algorithm ( Iterative Topological Sort)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                map[i][color[i] - 'a'] = 1;
            }
        }

        int res = 0;
        int seen = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            seen++;

            int max = getMax(map[node]);
            res = Math.max(res, max);

            for (int neighbor : adj.get(node)) {
                // update the map of next node
                for (int i = 0; i < 26; i++) {
                    map[neighbor][i] = Math.max(map[neighbor][i], map[node][i] + (color[neighbor] - 'a' == i ? 1 : 0));
                }
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        // if seen!=n means cycle is there
        return seen == n ? res : -1;
    }

    private int getMax(int[] num) {
        int max = num[0];
        for (int n : num) {
            max = Math.max(n, max);
        }
        return max;
    }

}