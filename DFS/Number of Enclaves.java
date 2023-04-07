class Solution {
    private static final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int enclaves = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    enclaves += checkEnclave(i, j, grid, vis).getValue();
                }
            }
        }
        return enclaves;
    }

    private Pair<Boolean, Integer> checkEnclave(int i, int j, int[][] grid, boolean[][] vis) {
        if (!isValid(i, j, grid.length, grid[0].length))
            return new Pair(false, 0);
        if (grid[i][j] == 0 || vis[i][j])
            return new Pair(true, 0);
        vis[i][j] = true;
        boolean isEnclave = true;
        int connectedEnclaves = 0;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            Pair<Boolean, Integer> p = checkEnclave(x, y, grid, vis);
            isEnclave &= p.getKey();
            connectedEnclaves += p.getValue();
        }
        if (!isEnclave) {
            return new Pair(false, 0);
        }
        return new Pair(true, 1 + connectedEnclaves);
    }

    private boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}