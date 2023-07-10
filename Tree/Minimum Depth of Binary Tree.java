/**
 * Approach: BFS
 * TC, SC : O(N)
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (q.isEmpty() == false) {
            int qSize = q.size();

            while (qSize > 0) {
                qSize--;

                TreeNode node = q.remove();
                // Since we added nodes without checking null, we need to skip them here.
                if (node == null) {
                    continue;
                }

                // The first leaf would be at minimum depth, hence return it.
                if (node.left == null && node.right == null) {
                    return depth;
                }

                q.add(node.left);
                q.add(node.right);
            }
            depth++;
        }
        return -1;
    }
};

/**
 * Approach: DFS
 * TC, SC : O(N)
 */

class DFSSolution {
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 1);
        return minDepth;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null || depth >= minDepth)
            return;
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}