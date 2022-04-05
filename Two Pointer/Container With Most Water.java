class Solution {
    public int maxArea(int[] height) {
        int area = 0, i = 0, j = height.length -1;
        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) i++; else j--;
        }
        return area;
    }
}