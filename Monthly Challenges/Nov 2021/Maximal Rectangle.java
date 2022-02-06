class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix==null) return 0;
        int[] heights = new int[matrix[0].length];
        int maxArea=-1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='0'){
                    heights[j] = 0;
                } else {
                    heights[j] ++;
                }
            }            
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int leftHeight[] = new int[n];
        int rightHeight[] = new int[n];
        leftHeight[0] = -1;
        rightHeight[n-1] = n;
        for( int i=1;i<n;i++){
            int p=i-1;
            while(p>=0 && heights[p]>=heights[i]){
                p=leftHeight[p];
            }
            leftHeight[i]=p;
        }
        for( int i=n-1;i>=0;i--){
            int p=i+1;
            while(p<n && heights[p]>=heights[i]){
                p=rightHeight[p];
            }
            rightHeight[i]=p;
        }
        for( int i=0;i<n;i++){
            max=Math.max(max, heights[i]*(rightHeight[i]-leftHeight[i]-1));
        }
        return max;
    }
}