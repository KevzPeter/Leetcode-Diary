// 20-02-2022
class Solution {
    // Tc : O(NLogN)
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            int n = intervals.length;
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int right = 0;
            int res = 0;
            for (int[] interval : intervals) {
                if (interval[1] > right) {
                    res++;
                    right = interval[1];
                }
            }
            return res;
        }
    }
}
// TC : O(n^2)
/*
 * public int removeCoveredIntervals(int[][] intervals) {
 * int n = intervals.length;
 * boolean[] removed = new boolean[n];
 * for(int i=0; i<n; i++){
 * for(int j=i+1; j<n; j++){
 * int a = intervals[i][0];
 * int b = intervals[i][1];
 * int c = intervals[j][0];
 * int d = intervals[j][1];
 * if(c <= a && b <= d){
 * removed[i] = true;
 * break;
 * }
 * }
 * }
 * for(int i=n-1; i>=0; i--){
 * for(int j=i-1; j>=0; j--){
 * int a = intervals[i][0];
 * int b = intervals[i][1];
 * int c = intervals[j][0];
 * int d = intervals[j][1];
 * if(c <= a && b <= d){
 * removed[i] = true;
 * break;
 * }
 * }
 * }
 * int count = 0;
 * for(int i=0; i<n; i++){
 * if(!removed[i]) count++;
 * }
 * return count;
 * }
 * }
 */