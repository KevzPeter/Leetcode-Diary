/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> path1 = new ArrayList<>();
    List<TreeNode> path2 = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findpath(root, p, true);
        findpath(root, q, false);
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i - 1);
    }

    boolean findpath(TreeNode root, TreeNode x, boolean check) {
        if (root == null)
            return false;
        if (check)
            path1.add(root);
        else
            path2.add(root);
        if (root.val == x.val)
            return true;
        if (findpath(root.left, x, check) || findpath(root.right, x, check))
            return true;
        if (check)
            path1.remove(path1.size() - 1);
        else
            path2.remove(path2.size() - 1);
        return false;
    }
}