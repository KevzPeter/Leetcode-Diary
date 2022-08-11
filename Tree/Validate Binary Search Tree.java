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
    Integer prev, curr = null;

    public boolean isValidBST(TreeNode root) {
        boolean ans = true;
        if (root.left != null)
            ans &= isValidBST(root.left);
        prev = curr;
        curr = root.val;
        if (prev != null && curr <= prev)
            return false;
        if (root.right != null)
            ans &= isValidBST(root.right);
        return ans;
    }
}