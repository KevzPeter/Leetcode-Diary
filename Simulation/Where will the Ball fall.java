class Solution {
    public int[] findBall(int[][] grid) {
        if(grid == null || grid.length == 0) return new int[0];
        
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];
        
        for(int c = 0; c < n; c++){
            int col = c, row = 0;
            
            while(row < m && col < n){
                if(grid[row][col] == 1 && (col == n - 1 || col < n - 1 && grid[row][col + 1] == -1) || 
                   grid[row][col] == -1 && (col == 0 || col > 0 && grid[row][col - 1] == 1)){
                    break;
                }
                col += grid[row][col];
                row += 1;
            }
            
            ans[c] = row == m ? col : -1;
        }
        
        return ans;
    }
}