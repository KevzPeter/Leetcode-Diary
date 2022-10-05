/* Daily challenge : 5/10/22
   TC : O(n)
   SC : O(n)
*//**
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null)
            return null;
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currDepth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode temp = q.poll();
                TreeNode leftSubTree = null;
                TreeNode rightSubTree = null;
                if (currDepth == depth - 1) {
                    if (temp.left != null) {
                        leftSubTree = temp.left;
                    }
                    if (temp.right != null) {
                        rightSubTree = temp.right;
                    }
                    temp.left = new TreeNode(val);
                    temp.right = new TreeNode(val);
                    temp.left.left = leftSubTree;
                    temp.right.right = rightSubTree;
                } else {
                    if (temp.left != null)
                        q.offer(temp.left);
                    if (temp.right != null)
                        q.offer(temp.right);
                }
            }
            if (currDepth == depth - 1)
                break;
            currDepth++;
        }
        return root;
    }
}