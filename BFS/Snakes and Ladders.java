class Solution {
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0)
            return 0;
        int n = board.length;
        reverse(board);
        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n * n + 1];
        q.offer(new int[] { 1, 0 });
        vis[1] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int pos = temp[0];
            int moves = temp[1];
            for (int i = 1; i <= 6; i++) {
                int newPos = pos + i;
                int[] coor = posToRC(newPos, n);
                int row = coor[0];
                int col = coor[1];
                if (board[row][col] != -1) {
                    newPos = board[row][col];
                }
                if (newPos == n * n)
                    return moves + 1;
                if (!vis[newPos]) {
                    q.offer(new int[] { newPos, moves + 1 });
                    vis[newPos] = true;
                }
            }
        }
        return -1;
    }

    private int[] posToRC(int pos, int n) {
        pos = pos - 1;
        int row = pos / n;
        int col = pos % n;
        if (row % 2 != 0)
            col = n - col - 1;
        return new int[] { row, col };
    }

    private void reverse(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = board[i][j];
                board[i][j] = board[n - i - 1][j];
                board[n - i - 1][j] = temp;
            }
        }
    }
}