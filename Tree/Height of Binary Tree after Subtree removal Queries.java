import java.util.*;

class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> levelMap = new HashMap<>();
        HashMap<Integer, List<Pair<Integer, Integer>>> maxNodeMap = new HashMap<>();

        List<List<TreeNode>> list = new ArrayList<>();

        levelOrderTraversal(root, list, levelMap);

        for (int i = list.size() - 1; i >= 0; i--) {
            List<TreeNode> level = list.get(i);
            List<Pair<Integer, Integer>> sortedList = new ArrayList<>();
            for (TreeNode node : level) {
                int maxChildren = 0;
                if (i == list.size() - 1) {
                    map.put(node.val, 0);
                    sortedList.add(new Pair(node.val, maxChildren));
                } else {
                    if (node.left != null) {
                        maxChildren = Math.max(maxChildren, map.get(node.left.val) + 1);
                    }
                    if (node.right != null) {
                        maxChildren = Math.max(maxChildren, map.get(node.right.val) + 1);
                    }
                    map.put(node.val, maxChildren);
                    sortedList.add(new Pair(node.val, maxChildren));
                }
            }
            Collections.sort(sortedList, (a, b) -> (b.getValue() - a.getValue()));
            // if (sortedList.size() > 2)
            // sortedList.subList(2, sortedList.size()).clear();
            maxNodeMap.put(i, sortedList);
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int nodeVal = queries[i];
            int lvl = levelMap.get(nodeVal);
            List<Pair<Integer, Integer>> ds = maxNodeMap.get(lvl);
            if (ds.get(0).getKey() == nodeVal)
                res[i] = ds.size() > 1 ? ds.get(1).getValue() + lvl : lvl - 1;
            else
                res[i] = ds.get(0).getValue() + lvl;
        }
        return res;
    }

    private void levelOrderTraversal(TreeNode root, List<List<TreeNode>> list, HashMap<Integer, Integer> levelMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<TreeNode> ds = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
                ds.add(temp);
                levelMap.put(temp.val, list.size());
            }
            list.add(ds);
        }
    }
}