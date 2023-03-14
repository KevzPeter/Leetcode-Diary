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
    private int sum;

    public int sumNumbers(TreeNode root) {
        calculateSum(root, 0);
        return sum;
    }

    private void calculateSum(TreeNode root, int currSum) {
        if (root == null)
            return;
        currSum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += currSum;
        }
        calculateSum(root.left, currSum);
        calculateSum(root.right, currSum);
    }
}