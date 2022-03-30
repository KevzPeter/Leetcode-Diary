class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            if(matrix[i][n-1] >= target){
                return binSearch(matrix[i], target, 0, n-1);
            }
        }
        return false;
    }
    private boolean binSearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}