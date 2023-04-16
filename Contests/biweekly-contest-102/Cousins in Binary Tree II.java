
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
import java.util.*;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null)
            return root;
        findLevelSum(root, 0);
        root.val = 0;
        replaceValues(root, 0);
        return root;
    }

    private void findLevelSum(TreeNode root, int level) {
        if (root == null)
            return;
        map.put(level, map.getOrDefault(level, 0) + root.val);
        findLevelSum(root.left, level + 1);
        findLevelSum(root.right, level + 1);
    }

    private void replaceValues(TreeNode root, int level) {
        int leftChildVal = root.left == null ? 0 : root.left.val;
        int rightChildVal = root.right == null ? 0 : root.right.val;
        int childrenSum = leftChildVal + rightChildVal;
        if (root.left != null) {
            root.left.val = map.get(level + 1) - childrenSum;
            replaceValues(root.left, level + 1);
        }
        if (root.right != null) {
            root.right.val = map.get(level + 1) - childrenSum;
            replaceValues(root.right, level + 1);
        }
    }
}