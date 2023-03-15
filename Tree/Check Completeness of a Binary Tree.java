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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return false;
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            int nodesOnCurrentLevel = sz;
            TreeNode prevNode = null;
            for (int i = 0; i < sz; i++) {
                TreeNode currNode = q.poll();
                if (prevNode != null && (prevNode.left == null || prevNode.right == null) &&
                        (currNode.left != null || currNode.right != null))
                    return false;
                prevNode = currNode;
                if (currNode.left == null && currNode.right != null)
                    return false;
                if (currNode.left != null)
                    q.offer(currNode.left);
                if (currNode.right != null)
                    q.offer(currNode.right);
            }
            if (!q.isEmpty() && nodesOnCurrentLevel != (1 << (height))) {
                return false;
            }
            ++height;
        }
        return true;
    }
}