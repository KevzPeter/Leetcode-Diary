class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        return check(board) && checkSubBox(board);
    }

    private boolean check(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] rowFreq = new int[10];
            int[] colFreq = new int[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowFreq[board[i][j] - '0']++;
                    if (rowFreq[board[i][j] - '0'] > 1)
                        return false;
                }
                if (board[j][i] != '.') {
                    colFreq[board[j][i] - '0']++;
                    if (colFreq[board[j][i] - '0'] > 1)
                        return false;
                }
            }
        }
        return true;
    }

    private boolean checkSubBox(char[][] board) {
        int rowIdx = 0;
        int colIdx = 0;
        while (rowIdx < 9) {
            while (colIdx < 9) {
                int[] freq = new int[10];
                for (int i = rowIdx; i < rowIdx + 3; i++) {
                    for (int j = colIdx; j < colIdx + 3; j++) {
                        if (board[i][j] != '.') {
                            freq[board[i][j] - '0']++;
                            if (freq[board[i][j] - '0'] > 1)
                                return false;
                        }
                    }
                }
                colIdx += 3;
            }
            colIdx = 0;
            rowIdx += 3;
        }
        return true;
    }
}