class Solution {
    private static final int MOD = (int) (1e9 + 7);
    private static final int[][] MOVES = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
            { -1, -2 } };
    private static final char[][] NUMPAD = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' },
            { '*', '0', '#' } };
    private static int[][] memo = new int[10][5000];

    public int knightDialer(int n) {
        int ans = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 3; col++) {
                if (NUMPAD[row][col] == '*' || NUMPAD[row][col] == '#')
                    continue;
                ans = (ans + (helper(row, col, n - 1) % MOD)) % MOD;
            }
        }
        return ans;

    }

    private int helper(int row, int col, int n) {
        if (!isValid(row, col) || NUMPAD[row][col] == '*' || NUMPAD[row][col] == '#')
            return 0;
        if (n == 0)
            return 1;
        int digit = NUMPAD[row][col] - '0';
        if (memo[digit][n] != 0)
            return memo[digit][n];
        int ans = 0;
        for (int[] move : MOVES) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            ans = (ans + (helper(newRow, newCol, n - 1) % MOD)) % MOD;
        }
        return memo[digit][n] = ans;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < 4 && j >= 0 && j < 3;
    }
}