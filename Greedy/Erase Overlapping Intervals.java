class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int overlappingIntervals = 1;
        int n = intervals.length;
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                ++overlappingIntervals;
            }
        }
        return n - overlappingIntervals;
    }
}