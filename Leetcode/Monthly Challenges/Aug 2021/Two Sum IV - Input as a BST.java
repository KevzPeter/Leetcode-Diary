import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        Set <Integer> avl=new HashSet<>();
        while(queue.size()>0){
            TreeNode popped=queue.remove();
            if(avl.contains(k-popped.val))
                return true;
            else
                avl.add(popped.val);
            if(popped.left!=null)
                queue.add(popped.left);
            if(popped.right!=null)
                queue.add(popped.right);
        }
        return false;
    }
}