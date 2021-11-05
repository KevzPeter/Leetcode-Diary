class Solution {
    public boolean exist(char[][] board, String word) {
        
        if(word.length()==0 || word==null) return false;
        
        if(board==null || board.length==0) return false;
        
        
        for( int i=0;i<board.length;i++){
            for( int j=0;j<board[0].length;j++){
                int[][]vis=new int[board.length][board[0].length];
                if(board[i][j]==word.charAt(0) && check(i,j,word,0,board,vis)) return true;
            }
        }
        return false;
    }
    
    boolean check(int i, int j, String word, int idx, char[][] board, int[][]vis){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || idx>=word.length()
          || word.charAt(idx)!=board[i][j] || vis[i][j]==1) return false;
        
        vis[i][j]=1;
        
        if(idx==word.length()-1) return true;
        
        if( check(i+1,j, word, idx+1, board,vis) 
           || check(i,j+1,word,idx+1,board,vis)
           ||check(i-1,j, word, idx+1, board,vis) 
           || check(i,j-1, word, idx+1, board,vis)
          ) return true;
        vis[i][j] = 0;
        return false;
    }
}