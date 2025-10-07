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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> levelSums = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            int levelSum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
                levelSum += temp.val;
            }
            levelSums.add(levelSum);
        }
        helper(root, 0, levelSums, 0);
        return root;
    }

    private void helper(TreeNode curr, int level, List<Integer> levelSums, int diff) {
        if (curr == null)
            return;
        if (level <= 1) {
            curr.val = 0;
        } else {
            curr.val = levelSums.get(level) - diff;
        }
        int leftVal = 0, rightVal = 0;
        if (curr.left != null) {
            leftVal = curr.left.val;
        }
        if (curr.right != null) {
            rightVal = curr.right.val;
        }
        diff = leftVal + rightVal;
        helper(curr.left, level + 1, levelSums, diff);
        helper(curr.right, level + 1, levelSums, diff);
    }
}