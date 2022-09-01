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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxVal) {
        if (root == null)
            return 0;
        int ans = 0;
        if (root.val >= maxVal) {
            maxVal = root.val;
            ans++;
        }
        ans += dfs(root.left, maxVal) + dfs(root.right, maxVal);
        return ans;
    }
}