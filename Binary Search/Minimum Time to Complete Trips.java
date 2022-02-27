class Solution {
    public long minimumTime(int[] times, int totalTrips) {
        long low = 1;
        long high = (long) Arrays.stream(times).min().getAsInt() * totalTrips;
        while (low < high) {
            long mid = low + ((high - low) / 2);
            if (!getTime(mid, totalTrips, times)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private boolean getTime(long currTime, int totalTrips, int[] times) {
        long sum = 0;
        for (int time : times) {
            sum += currTime / time;
        }
        return sum >= totalTrips;
    }
}