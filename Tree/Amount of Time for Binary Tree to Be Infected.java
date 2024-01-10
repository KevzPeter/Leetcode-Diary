/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int time = 0;

    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        traverseTree(root, null, adj);
        dfs(start, adj, 0, new HashSet<Integer>());
        return time;
    }

    private void dfs(int currentNode, HashMap<Integer, HashSet<Integer>> adj, int currentTime,
            HashSet<Integer> visited) {
        visited.add(currentNode);
        time = Math.max(time, currentTime);
        if (adj.containsKey(currentNode) && !adj.get(currentNode).isEmpty()) {
            for (int neighbor : adj.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, adj, currentTime + 1, visited);
                }
            }
        }
    }

    private void traverseTree(TreeNode root, TreeNode parent, HashMap<Integer, HashSet<Integer>> adj) {
        if (root == null)
            return;
        if (parent != null) {
            addToMap(adj, parent, root);
        }
        traverseTree(root.left, root, adj);
        traverseTree(root.right, root, adj);
    }

    private void addToMap(HashMap<Integer, HashSet<Integer>> map, TreeNode a, TreeNode b) {
        if (!map.containsKey(a.val))
            map.put(a.val, new HashSet<>());
        if (!map.containsKey(b.val))
            map.put(b.val, new HashSet<>());
        map.get(a.val).add(b.val);
        map.get(b.val).add(a.val);
    }
}