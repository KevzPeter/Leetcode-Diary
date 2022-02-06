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
//recursive inorder approach and dfs approach
class Solution {
    int max;
    int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
    //     max=0;
    //     inorder(root);
    //     return max;
    // }
    // int leftLength(TreeNode root, int l){
    //     if(root==null) return l;
    //     return Math.max(leftLength(root.left, l+1), leftLength(root.right, l+1));
    // }
    // int rightLength(TreeNode root, int l){
    //     if(root==null) return l;
    //     return Math.max(leftLength(root.left, l+1), rightLength(root.right, l+1));
    // }
    // void inorder(TreeNode root){
    //     if(root==null) return;
    //     inorder(root.left);
    //     max=Math.max(max,(leftLength(root.left,0)+rightLength(root.right,0)));
    //     inorder(root.right);
    // }
        dfs(root);
		return dia;
    }
	
	int dfs(TreeNode root) {
		if(root==null) return -1;
		
		int h1=dfs(root.left);
		int h2=dfs(root.right);
		dia=Math.max(dia, h1+h2+2);
		return Math.max(h1, h2)+1;
}
}