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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, TreeNode> tMap = new HashMap<>();

        for (int[] desc : descriptions) {
            int parent = desc[0], child = desc[1], isLeft = desc[2];

            TreeNode p = !tMap.containsKey(parent) ? new TreeNode(parent) : tMap.get(parent);
            tMap.put(parent, p);

            TreeNode c = !tMap.containsKey(child) ? new TreeNode(child) : tMap.get(child);
            tMap.put(child, c);

            p.left = isLeft == 1 ? c : p.left;
            p.right = isLeft == 0 ? c : p.right;

            set.add(child);
        }

        for (int[] desc : descriptions) {
            int parent = desc[0];
            if (!set.contains(parent)) {
                return tMap.get(parent);
            }
        }

        return null;
    }
}