import java.util.*;

public class BinarySearchTree {
    static TreeNode root;

    public static void main(String[] args) {

        int[] arr = { 55, 45, 20, 10, 35, 40, 15, 25, 30, 50, 5 };
        Arrays.sort(arr);
        root = buildTree(arr, 0, arr.length - 1);
        printInorder(root);
    }

    static TreeNode buildTree(int[] arr, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = buildTree(arr, start, mid - 1);
        node.right = buildTree(arr, mid + 1, end);
        return node;
    }

    static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}
