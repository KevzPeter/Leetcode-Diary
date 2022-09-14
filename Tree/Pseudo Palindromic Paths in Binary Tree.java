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
// using bitwise operations to keep track of frequency of values
class Solution1 {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        int ans = 0;
        path ^= (1 << root.val);
        if (root.left == null && root.right == null) {
            ans += (path & (path - 1)) == 0 ? 1 : 0;
        }
        if (root.left != null)
            ans += dfs(root.left, path);
        if (root.right != null)
            ans += dfs(root.right, path);
        return ans;
    }
}

// using arraylist to keep track of frequency of values
class Solution2 {
    public int pseudoPalindromicPaths(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(0);
        }
        return dfs(root, list);
    }

    private int dfs(TreeNode root, List<Integer> list) {
        int ans = 0;
        list.set(root.val, list.get(root.val) + 1);
        if (root.left == null && root.right == null) {
            int oddFreqs = 0;
            boolean flag = true;
            for (int i = 0; i < 10; i++) {
                if (list.get(i) % 2 == 1)
                    oddFreqs++;
                if (oddFreqs > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans += 1;
        }
        if (root.left != null)
            ans += dfs(root.left, new ArrayList<>(list));
        if (root.right != null)
            ans += dfs(root.right, new ArrayList<>(list));
        return ans;
    }
}