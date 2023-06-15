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
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        int currLevel = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            int currSum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode temp = q.poll();
                currSum += temp.val;
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
            if (currSum > maxSum) {
                maxSum = currSum;
                maxLevel = currLevel;
            }
            ++currLevel;
        }
        return maxLevel;
    }
}