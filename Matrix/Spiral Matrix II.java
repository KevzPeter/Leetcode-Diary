class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        boolean[][] seen = new boolean[n][n];
        int i = 0, j = 0, count = 1, d = 0;
        while(count - 1 < (n * n)){
            res[i][j] = count;
            seen[i][j] = true;
            count++;
            int i2 = i + DIRS[d][0];
            int j2 = j + DIRS[d][1];
            if(!isValid(i2, j2, n, n) || seen[i2][j2])
                d = (d+1) % 4;
            i += DIRS[d][0];
            j += DIRS[d][1];
        }
        return res;
    }
    private boolean isValid(int i, int j, int m, int n){
        return (i>=0 && i<m && j>=0 && j<n);
    }
}