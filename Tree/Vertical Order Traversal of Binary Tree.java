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
    static class NodeComparator implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            return p1.getValue() == p2.getValue() ? p1.getKey() - p2.getKey() : p1.getValue() - p2.getValue();
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeMap<Integer, List<Pair<Integer, Integer>>> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        for (Map.Entry<Integer, List<Pair<Integer, Integer>>> e : map.entrySet()) {
            List<Pair<Integer, Integer>> list = e.getValue();
            Collections.sort(list, new NodeComparator());
            List<Integer> ds = new ArrayList<>();
            for (Pair<Integer, Integer> p : list) {
                ds.add(p.getKey());
            }
            res.add(ds);
        }
        return res;
    }

    private void dfs(TreeNode root, TreeMap<Integer, List<Pair<Integer, Integer>>> map, int col, int row) {
        if (root == null)
            return;
        dfs(root.left, map, col - 1, row + 1);
        if (!map.containsKey(col)) {
            map.put(col, new ArrayList<Pair<Integer, Integer>>());
        }
        map.get(col).add(new Pair(root.val, row));
        dfs(root.right, map, col + 1, row + 1);
    }
}