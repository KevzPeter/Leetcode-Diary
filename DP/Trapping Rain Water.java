class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] tallerToRight = new int[n];
        int[] tallerToLeft = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                tallerToLeft[i] = height[i];
                tallerToRight[n - i - 1] = height[n - i - 1];
            } else {
                tallerToLeft[i] = Math.max(tallerToLeft[i - 1], height[i]);
                tallerToRight[n - i - 1] = Math.max(tallerToRight[n - i], height[n - i - 1]);
            }
        }
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(tallerToLeft[i], tallerToRight[i]) - height[i];
        }
        return trappedWater;
    }
}