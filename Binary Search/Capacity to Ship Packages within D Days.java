class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int need = 1, curr = 0;
            for (int weight : weights) {
                if (curr + weight > mid) {
                    curr = 0;
                    need++;
                }
                curr += weight;
            }
            if (need > days) {
                low = mid + 1;
            } else
                high = mid;
        }
        return low;
    }
}