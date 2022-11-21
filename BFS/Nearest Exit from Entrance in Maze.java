import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int steps = 1;
        int eRow = entrance[0], eCol = entrance[1];

        q.offer(entrance);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cell = q.poll();
                for (int[] dir : DIRS) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    if (insideMaze(row, col, m, n) && maze[row][col] == '.' && !visited[row][col]) {
                        if (!(row == eRow && col == eCol) && isOnBorder(row, col, m, n))
                            return steps;
                        visited[row][col] = true;
                        q.offer(new int[] { row, col });
                    }
                }
            }
            ++steps;
        }

        return -1;
    }

    private boolean insideMaze(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    private boolean isOnBorder(int row, int col, int m, int n) {
        return row == 0 || row == m - 1 || col == 0 || col == n - 1;
    }
}