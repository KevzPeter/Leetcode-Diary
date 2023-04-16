class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int maxOnes = 0;
        int col = 0;
        for (int i = 0; i < m; i++) {
            int currOnes = 0;
            for (int j = 0; j < n; j++) {
                currOnes += mat[i][j];
            }
            if (currOnes > maxOnes) {
                maxOnes = currOnes;
                col = i;
            }
        }
        return new int[] { col, maxOnes };
    }
}