import java.util.*;

class Solution {
    int index = 0;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return convertTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode convertTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int rootVal = preorder[index++];
        int idx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = convertTree(preorder, left, idx - 1);
        root.right = convertTree(preorder, idx + 1, right);
        return root;
    }
}