class Solution {
    public char[][] rotateTheBox(char[][] box) {
        if (box == null || box.length == 0 || box[0].length == 0)
            return null;
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            int stones = 0;
            for (int j = 0; j < n; j++) {
                res[j][m - i - 1] = '.';
                if (box[i][j] == '#') {
                    stones++;
                } else if (box[i][j] == '*') {
                    res[j][m - i - 1] = '*';
                    for (int k = 1; k <= stones; k++) {
                        res[j - k][m - i - 1] = '#';
                    }
                    stones = 0;
                }
            }
            for (int k = 1; k <= stones; k++) {
                res[n - k][m - i - 1] = '#';
            }
        }
        return res;
    }
}