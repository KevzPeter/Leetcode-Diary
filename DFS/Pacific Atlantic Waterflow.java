public class Solution {
    int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        // One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) { // Vertical border
            pQueue.offer(new int[] { i, 0 });
            aQueue.offer(new int[] { i, m - 1 });
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        for (int i = 0; i < m; i++) { // Horizontal border
            pQueue.offer(new int[] { 0, i });
            aQueue.offer(new int[] { n - 1, i });
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[] { i, j });
            }
        }
        return res;
    }

    public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int n = matrix.length, m = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[] { x, y });
            }
        }
    }
}
// TC : O((mn)^2)
// SC : O(mn)
/*
 * class Solution {
 * private static final int DIRS[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
 * public List<List<Integer>> pacificAtlantic(int[][] heights) {
 * List<List<Integer>> res = new ArrayList<>();
 * int m = heights.length;
 * int n = heights[0].length;
 * int[][] bordersA = new int[m][n];
 * int[][] bordersP = new int[m][n];
 * for(int i=0; i<m; i++){
 * for(int j=0; j<n; j++){
 * dfs(i, j, i, j, heights, new int[m][n], bordersA, bordersP, m, n);
 * }
 * }
 * for(int i=0; i<m; i++){
 * for(int j=0; j<n; j++){
 * if(bordersA[i][j] == 1 && bordersP[i][j] == 1){
 * List<Integer> ds = new ArrayList<>();
 * ds.add(i); ds.add(j);
 * res.add(new ArrayList<>(ds));
 * }
 * }
 * }
 * return res;
 * }
 * private void dfs(int startR, int startC, int i, int j, int[][]heights,
 * int[][] vis, int[][]bordersA, int[][]bordersP, int m, int n){
 * if(vis[i][j] == 1) return;
 * vis[i][j] = 1;
 * if(bordersA(i, j, m, n) && bordersP(i, j)){
 * bordersA[startR][startC] = 1;
 * bordersP[startR][startC] = 1;
 * return;
 * }
 * else if(bordersA(i, j, m, n)){
 * bordersA[startR][startC] = 1;
 * }
 * else if(bordersP(i, j)){
 * bordersP[startR][startC] = 1;
 * }
 * for(int[] dir : DIRS){
 * int newRow = i + dir[0];
 * int newCol = j + dir[1];
 * if(isValid(newRow, newCol, m, n) && heights[newRow][newCol] <=
 * heights[i][j]){
 * dfs(startR, startC, newRow, newCol, heights, vis, bordersA, bordersP, m, n);
 * }
 * }
 * }
 * private boolean bordersA(int i, int j, int m, int n){
 * return (j == n - 1 || i == m - 1);
 * }
 * private boolean bordersP(int i, int j){
 * return (i == 0 || j == 0);
 * }
 * private boolean isValid(int i, int j, int m, int n){
 * return (i >=0 && i < m && j >=0 && j < n);
 * }
 * }
 */