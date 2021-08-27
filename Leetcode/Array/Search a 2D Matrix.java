class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        ArrayList<Integer> col=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            if(target>matrix[i][matrix[0].length-1])
                continue;
            else{
               return bin_search(matrix[i], 0, matrix[0].length-1, target);
            }
        }
        return false;
    }
    boolean bin_search(int []arr, int start, int end, int target){
        int mid = start +(end-start)/2;
        while(start<=end){
            if(arr[mid]==target)
                return true;
            if(arr[mid]>target)
                return bin_search(arr, start, mid-1, target);
            else
                return bin_search(arr, mid+1, end, target);
        }
        return false;
    }
}