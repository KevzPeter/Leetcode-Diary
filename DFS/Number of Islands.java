class Solution {
    private static final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (isValid(x, y, grid.length, grid[0].length) && grid[x][y] == '1') {
                dfs(x, y, grid);
            }
        }
    }

    private boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && j >= 0 && i < n && j < m);
    }
}