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
    int xp, xl, yp, yl;
    public boolean isCousins(TreeNode root, int x, int y) {
        inorder(root, null,0, x, y);
        if(xp!=yp && xl==yl) return true;
        return false;
    }
    void inorder(TreeNode root, TreeNode parent, int lvl, int x, int y){
      if(root==null) return;
      if(root.left!=null) inorder(root.left, root, lvl+1, x, y);
      if(root.val==x){
        xp=parent==null?0:parent.val;
        xl=lvl;
      }
      if(root.val==y){
        yp=parent==null?0:parent.val;
        yl=lvl;
      }
      if(root.right!=null) inorder(root.right, root, lvl+1, x, y);
    }
}