/*
You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.

Input: edges = [3,3,4,2,3]
Output: 3
Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
The length of this cycle is 3, so 3 is returned.

Input: edges = [2,-1,3,1]
Output: -1
Explanation: There are no cycles in this graph.

 */

class Solution {
    public int longestCycle(int[] edges) {
        int res = -1;
        if (edges == null || edges.length == 0)
            return res;
        int n = edges.length;
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int idx = i, dist = 0; idx != -1; idx = edges[idx]) {
                    if (map.containsKey(idx)) {
                        res = Math.max(res, dist - map.get(idx));
                        break;
                    }
                    if (vis[idx] == 1)
                        break;
                    vis[idx] = 1;
                    map.put(idx, dist++);
                }
            }
        }
        return res;
    }
}