class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < times.length; j++) {
                int start = times[j][0];
                int end = times[j][1];
                int t = times[j][2];
                if (dist[start] != Integer.MAX_VALUE)
                    dist[end] = Math.min(dist[end], dist[start] + t);
            }
        }
        int maxwait = 0;
        for (int i = 1; i <= n; i++)
            maxwait = Math.max(maxwait, dist[i]);
        return maxwait == Integer.MAX_VALUE ? -1 : maxwait;
    }
}