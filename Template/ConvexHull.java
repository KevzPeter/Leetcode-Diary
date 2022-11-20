public class Solution {
    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public int[][] outerTrees(int[][] points) {

        final int n = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p, int[] q) {
                return q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0];
            }
        });
        Stack<int[]> upperHull = new Stack<>();
        Stack<int[]> lowerHull = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            int uSize = upperHull.size();
            int lSize = lowerHull.size();
            while (uSize >= 2 && orientation(upperHull.get(uSize - 2), upperHull.get(uSize - 1), points[i]) > 0) {
                --uSize;
                upperHull.pop();
            }
            upperHull.push(points[i]);
            while (lSize >= 2
                    && orientation(lowerHull.get(lSize - 2), lowerHull.get(lSize - 1), points[n - i - 1]) > 0) {
                --lSize;
                lowerHull.pop();
            }
            lowerHull.push(points[n - i - 1]);
        }
        // remove redundant elements from the stack
        HashSet<int[]> ret = new HashSet<>();
        ret.addAll(upperHull);
        ret.addAll(lowerHull);
        return ret.toArray(new int[ret.size()][]);
    }
}