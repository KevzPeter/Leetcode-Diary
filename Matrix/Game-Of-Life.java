class Solution {
    private static final int[][] DIRS = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private int live = 2;
    private int die = 3;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int liveCells = 0;
                for(int[] dir : DIRS){
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if(isValid(row, col, m, n)){
                        if(board[row][col] == 1 || board[row][col] == die) liveCells++;
                    }
                }
                if(board[i][j] == 1 && (liveCells < 2 || liveCells > 3)){
                    board[i][j] = die;
                }
                else if(board[i][j] == 0 && liveCells == 3){
                    board[i][j] = live;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == live) board[i][j] = 1;
                else if(board[i][j] == die) board[i][j] = 0;
            }
        }
    }
    private boolean isValid(int i, int j, int m, int n){
        return(i >= 0 && i < m && j >= 0 && j < n);
    }
}