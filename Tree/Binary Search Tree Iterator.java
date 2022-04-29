import java.util.*;

class BSTIterator {
    List<Integer> list;
    int curr;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        curr = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
    }

    public int next() {
        return list.get(curr++);
    }

    public boolean hasNext() {
        return (curr <= list.size() - 1);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */