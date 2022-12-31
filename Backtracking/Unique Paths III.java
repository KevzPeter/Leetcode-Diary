class Solution {
    private static final int[][] DIRS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int emptyCells = 0;
        int startRow = 0, startCol = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    emptyCells++;
                else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        int ans = findPaths(startRow, startCol, grid, new boolean[m][n], emptyCells);
        return ans;
    }

    private int findPaths(int i, int j, int[][] grid, boolean[][] visited, int emptyCells) {
        if (grid[i][j] == 2) {
            if (emptyCells == 0)
                return 1;
            return 0;
        }
        if (grid[i][j] == 0)
            --emptyCells;
        int paths = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int[] dir : DIRS) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (isValid(row, col, m, n) && !visited[row][col] && (grid[row][col] == 0 || grid[row][col] == 2)) {
                visited[i][j] = true;
                paths += findPaths(row, col, grid, visited, emptyCells);
                visited[i][j] = false;
            }
        }
        return paths;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}