class Solution {
    public int maxPoints(int[][] points) {
        if(points == null || points.length == 0 || points[0].length <= 1) return 0;
        int maxPoints = 1;
        int n = points.length;
        for(int i = 0; i < n; i++){
            HashMap<Double, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                if(i != j){
                    double slope = findSlope(points[i], points[j]);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    maxPoints = Math.max(map.get(slope) + 1, maxPoints);
                }
            }
        }
        return maxPoints;
    }
    private double findSlope(int[] p1, int[] p2){
        double x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];
        double slope = Math.atan((y2 - y1) / (x2 - x1));
        return slope;
    }
}