// Daily challenge : 5/10/22
// TC : O(N)
// SC : O(N) stack space
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}