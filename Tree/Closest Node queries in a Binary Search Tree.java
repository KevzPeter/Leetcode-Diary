import java.util.*;

// assuming BST is balanced, TC : O(N * logN)
// for a skewed tree, TC : O(N^2)
class Solution1 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        for (int query : queries) {
            Integer min = floor(root, query, Integer.MIN_VALUE);
            Integer max = ceiling(root, query, Integer.MAX_VALUE);
            min = min == Integer.MIN_VALUE ? -1 : min;
            max = max == Integer.MAX_VALUE ? -1 : max;
            res.add(new ArrayList<>(Arrays.asList(min, max)));
        }
        return res;
    }

    private Integer floor(TreeNode root, int query, int currFloor) {
        if (root == null)
            return currFloor;
        if (root.val == query)
            return query;
        if (root.val < query && root.val > currFloor) {
            currFloor = root.val;
            return floor(root.right, query, currFloor);
        } else
            return floor(root.left, query, currFloor);
    }

    private Integer ceiling(TreeNode root, int query, int currCeiling) {
        if (root == null)
            return currCeiling;
        if (root.val == query)
            return query;
        if (root.val > query && root.val < currCeiling) {
            currCeiling = root.val;
            return ceiling(root.left, query, currCeiling);
        } else
            return ceiling(root.right, query, currCeiling);
    }
}

// Using TreeSet, TC: O(N logN)
class Solution2 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(root, set);
        List<List<Integer>> res = new ArrayList<>();
        for (int query : queries) {
            Integer min = set.floor(query);
            Integer max = set.ceiling(query);
            res.add(new ArrayList<>(Arrays.asList(min == null ? -1 : min, max == null ? -1 : max)));
        }
        return res;
    }

    private void dfs(TreeNode root, TreeSet<Integer> set) {
        if (root == null)
            return;
        dfs(root.left, set);
        set.add(root.val);
        dfs(root.right, set);
    }
}