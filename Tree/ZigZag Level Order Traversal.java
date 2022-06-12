import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return List.of();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> ds = new LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
                if (level % 2 == 0)
                    ds.add(curr.val);
                else
                    ds.addFirst(curr.val);
            }
            res.add(new LinkedList<>(ds));
            level++;
        }

        return res;
    }
}