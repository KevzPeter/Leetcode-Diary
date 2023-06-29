class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int startRow = 0;
        int startCol = 0;
        int allKeys = 0;
        boolean[][][] visited = new boolean[m][n][64];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                } else if (c >= 'a' && c <= 'f') {
                    allKeys = (allKeys << 1) + 1;
                }
            }
        }

        Deque<int[]> bfsQueue = new ArrayDeque<int[]>();
        bfsQueue.offer(new int[] { startRow, startCol, 0, 0 });

        while (!bfsQueue.isEmpty()) {
            int[] curr = bfsQueue.poll();
            int row = curr[0];
            int col = curr[1];
            int distance = curr[2];
            int keys = curr[3];

            char c = grid[row].charAt(col);
            if (c >= 'a' && c <= 'f') {
                int key = 1 << (c - 'a');
                keys |= key;
            }

            if (visited[row][col][keys] == true)
                continue;

            visited[row][col][keys] = true;

            if (keys == allKeys)
                return distance;

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow >= m || nextCol >= n || nextRow < 0 || nextCol < 0)
                    continue;

                char nextChar = grid[nextRow].charAt(nextCol);

                if (nextChar == '#' || visited[nextRow][nextCol][keys])
                    continue;

                if (nextChar >= 'A' && nextChar <= 'F') {
                    int door = 1 << (nextChar - 'A');
                    if ((keys & door) == 0)
                        continue;
                }

                bfsQueue.offer(new int[] { nextRow, nextCol, distance + 1, keys });
            }
        }

        return -1;
    }
}