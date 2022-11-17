class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);
        int commonArea = 0;
        if (!(ax1 > bx2 || ax2 < bx1 || ay2 < by1 || ay1 > by2)) {
            int cx1 = Math.max(ax1, bx1);
            int cx2 = Math.min(ax2, bx2);
            int cy1 = Math.max(ay1, by1);
            int cy2 = Math.min(ay2, by2);
            commonArea = (cx2 - cx1) * (cy2 - cy1);
        }
        return areaA + areaB - commonArea;
    }
}