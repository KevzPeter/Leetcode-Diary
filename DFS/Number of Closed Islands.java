class Solution {
    private static final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int closedIslands = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    if (isClosedIsland(i, j, grid, vis)) {
                        closedIslands++;
                    }
                }
            }
        }
        return closedIslands;
    }

    private boolean isClosedIsland(int i, int j, int[][] grid, boolean[][] vis) {
        if (!isValid(i, j, grid.length, grid[0].length))
            return false;
        if (grid[i][j] == 1 || vis[i][j])
            return true;
        vis[i][j] = true;
        boolean ans = true;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            ans &= isClosedIsland(x, y, grid, vis);
        }
        return ans;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}