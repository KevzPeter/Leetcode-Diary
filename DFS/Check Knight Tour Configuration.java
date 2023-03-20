class Solution {
    private static final int[][] MOVES = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int i = 0, j = 0;
        for(int currMove = 0; currMove < (n * n) - 1; currMove++){
            int newPosI = i, newPosJ = j;
            checkMoves: for(int[] move : MOVES){
                int x = i + move[0];
                int y = j + move[1];
                if(isValid(x, y, n, n) && grid[x][y] == currMove + 1){
                    newPosI = x;
                    newPosJ = y;
                    break checkMoves;
                }
            }
            if(i == newPosI && j == newPosJ) return false;
            i = newPosI;
            j = newPosJ;
        }
        return true;
    }
    private boolean isValid(int i, int j, int m, int n){
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}