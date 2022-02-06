import java.util.*;
class Node{
    Node left;
    Node right;
}

 class Trie{
    Node root;
    Trie(){
        root=new Node();
    }
    void insert(int n){
        Node temp=root;
        for( int i=31;i>=0;i--){
            int bit=(n>>i)&1;
            if(bit==0){
                if(temp.left==null)
                temp.left=new Node();
                temp=temp.left;
            }
            else{
                if(bit!=0){
                    if(temp.right==null)
                    temp.right=new Node();
                    temp=temp.right;
                }
            }
        }
    }
    int max_xor_helper(int val){
        Node temp=root;
        int cursum=0;
        for( int i=31;i>=0;i--){
            int bit=(val>>i)&1;
            if(bit==0){
                if(temp.right!=null){
                    cursum+=(1<<i);
                    temp=temp.right;
                }
                else{
                    temp=temp.left;
                }
            }
            else{
                if(temp.left!=null)
                {
                    cursum+=(1<<i);
                    temp=temp.left;
                }
                else{
                    temp=temp.right;
                }
            }
        }
        return cursum;
    }
}
public class Solution{
    int solve(int[] arr){
        int n=arr.length;
        Trie t=new Trie();
        int maxxor=0;
        for(int i=0;i<n;i++){
            int val=arr[i];
            t.insert(val);
            int curmax=t.max_xor_helper(val);
            maxxor=Math.max(maxxor, curmax);
        }
        return maxxor;
    }
    public static void main(String args[]){
        Solution obj=new Solution();
        int[] array={0,3,1,0,7,7,2,6};
        int ans=obj.solve(array);
        System.out.println(ans);
    }
}