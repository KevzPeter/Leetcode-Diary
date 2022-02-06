//Day 2
class Solution {
    public int calculateMinimumHP(int[][] grid) {
         if(grid.length==0 || grid==null) return 1;
        
        int m=grid.length;
        int n=grid[0].length;
        
        int dp[][]=new int[m+1][n+1];
        
        for( int i=0;i<n;i++)
            dp[m][i]=Integer.MIN_VALUE;
        for( int i=0;i<m;i++)
            dp[i][n]=Integer.MIN_VALUE;
        
        dp[m][n-1]=dp[m-1][n]=0;
        
        for( int i=m-1;i>=0;i--){
            for( int j=n-1;j>=0;j--){
                int t=grid[i][j]+Math.max(dp[i+1][j],dp[i][j+1]);
                dp[i][j]=t<0?t:0;
            }
        }
        return Math.abs(dp[0][0])+1;
    }
}