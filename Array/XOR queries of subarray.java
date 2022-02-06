class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] ans=new int[queries.length], q;
        
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]^arr[i];
        }
        
        for(int i=0;i<queries.length;i++){
             q=queries[i];
            ans[i]=q[0]>0?prefix[q[0]-1]^prefix[q[1]]:prefix[q[1]];
        }
        return ans;
    }
}