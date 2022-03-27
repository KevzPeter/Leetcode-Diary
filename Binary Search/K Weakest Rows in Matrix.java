class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                soldiers += mat[i][j];
            }
            pq.offer(new int[] { soldiers, i });
        }
        int[] res = new int[k];
        int c = 0;
        while (c < k) {
            res[c++] = pq.poll()[1];
        }
        return res;
    }
}