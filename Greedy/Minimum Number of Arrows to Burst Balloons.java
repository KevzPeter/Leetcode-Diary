class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        int arrows = 1;
        Arrays.sort(points, (a, b) -> (Integer.compare(a[0], b[0])));
        int n = points.length;
        int r = points[0][1];
        for(int i = 1; i < n; i++){
            arrows += r >= points[i][0] ? 0 : 1;
            r = r >= points[i][0] && r < points[i][1] ? r : points[i][1];
        }
        return arrows;
    }
}