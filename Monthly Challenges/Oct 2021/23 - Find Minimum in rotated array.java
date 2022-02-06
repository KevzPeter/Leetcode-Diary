class Solution {
    public int findMin(int[] nums) {
       return binSearch(nums, 0, nums.length-1);
    }
    int binSearch(int[] arr, int low, int high){
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == arr[high])
                high--;

            else if(arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
    return arr[high];
    }
}