class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            int maxLength = 0;
            for (int i = 0; i < m; i++) {
                maxLength = Math.max(maxLength, countDigits(grid[i][j]));
            }
            ans[j] = maxLength;
        }
        return ans;
    }

    private int countDigits(int n) {
        if (n == 0)
            return 1;
        int digs = 0;
        if (n < 0) {
            n *= -1;
            digs++;
        }
        while (n > 0) {
            n /= 10;
            digs++;
        }
        return digs;
    }
}