class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length - 1)
            return -1;
        int low = 1, high = 10_000_000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            double totalTime = 0;
            for (int i = 0; i < dist.length; i++) {
                if (i == dist.length - 1) {
                    totalTime += ((double) dist[i] / mid);
                } else {
                    totalTime += Math.ceil(((double) dist[i] / mid));
                }
            }
            if (totalTime > hour) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}