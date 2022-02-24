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
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode _node, int _num) {
        node = _node;
        num = _num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int first = 0, last = 0;
            int min = q.peek().num;
            for (int i = 0; i < size; i++) {
                int num = q.peek().num;
                TreeNode node = q.peek().node;
                q.poll();
                if (i == 0)
                    first = num;
                if (i == size - 1)
                    last = num;
                if (node.left != null)
                    q.offer(new Pair(node.left, (num - min) * 2 + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, (num - min) * 2 + 2));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}