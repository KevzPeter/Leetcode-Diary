/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    static class TreeNode {
        boolean locked;
        int id;
        TreeNode parent;
        int lockedChildren;
        List<TreeNode> children;

        public TreeNode() {
            locked = false;
            id = -1;
            parent = null;
            children = new ArrayList<>();
            lockedChildren = 0;
        }

        public TreeNode(TreeNode _parent) {
            locked = false;
            id = -1;
            parent = _parent;
            children = new ArrayList<>();
            lockedChildren = 0;
        }
    }

    public static boolean lock(TreeNode node, int id) {
        if (node.locked || node.lockedChildren > 0)
            return false;
        for (TreeNode anc = node.parent; anc != null; anc = anc.parent) {
            if (anc.locked)
                return false;
        }
        for (TreeNode anc = node.parent; anc != null; anc = anc.parent) {
            anc.lockedChildren++;
        }
        node.id = id;
        node.locked = true;
        lockedNodes.add(node);
        return true;
    }

    public static boolean unlock(TreeNode node, int id) {
        if (!node.locked || (node.locked && node.id != id))
            return false;
        for (TreeNode anc = node.parent; anc != null; anc = anc.parent) {
            anc.lockedChildren--;
        }
        node.locked = false;
        node.id = -1;
        lockedNodes.remove(node);
        return true;
    }

    public static boolean upgrade(TreeNode node, int id) {
        if (node.locked || node.lockedChildren == 0)
            return false;
        List<TreeNode> lockedChildren = new ArrayList<>();
        for (TreeNode lockedNode : lockedNodes) {
            int lockedNodeID = lockedNode.id;
            for (TreeNode anc = lockedNode.parent; anc != null; anc = anc.parent) {
                if (anc == node) {
                    if (id != lockedNodeID)
                        return false;
                    lockedChildren.add(lockedNode);
                }
            }
        }
        // unlock all child descendants locked by same id:
        for (TreeNode lockedChild : lockedChildren) {
            unlock(lockedChild, id);
        }
        return lock(node, id);
    }

    static Map<String, TreeNode> map = new HashMap<>();
    static Set<TreeNode> lockedNodes = new HashSet<>();

    public static void main(String args[]) throws Exception {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int n, m, q;
        n = in.nextInt();
        m = in.nextInt();
        q = in.nextInt();
        in.nextLine();
        TreeNode root = new TreeNode();
        String d = in.nextLine();
        map.put(d, root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int k = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            while ((k < n) && temp.children.size() < m) {
                String s = in.nextLine();
                TreeNode u = new TreeNode(temp);
                map.put(s, u);
                temp.children.add(u);
                queue.offer(u);
                k++;
            }
        }
        for (int i = 0; i < q; i++) {
            int opType, id;
            String nodeName;
            String[] input = in.nextLine().split(" ");
            opType = Integer.parseInt(input[0]);
            nodeName = input[1];
            id = Integer.parseInt(input[2]);
            boolean ans;

            if (opType == 1) {
                ans = lock(map.get(nodeName), id);
            } else if (opType == 2) {
                ans = unlock(map.get(nodeName), id);
            } else {
                ans = upgrade(map.get(nodeName), id);
            }
            System.out.println(ans);
        }
        in.close();
    }
}

// 7
// 2
// 3
// World
// Asia
// Africa
// China
// India
// SouthAfrica
// Egypt
// 1 China 9
// 2 India 9
// 3 Asia 9
