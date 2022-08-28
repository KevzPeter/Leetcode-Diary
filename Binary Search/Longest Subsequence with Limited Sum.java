class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length, n = nums.length;
        int[] res = new int[m];
        int[] prefix = new int[n];
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            if(i == 0) prefix[i] = nums[i];
            else prefix[i] = prefix[i - 1] + nums[i];
        }
        for(int i = 0; i < m; i++){
            res[i] = binSearch(queries[i], prefix);
        }
        return res;
    }
    private int binSearch(int X, int[] arr){
        int mid;
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (X >= arr[mid]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        if(low < arr.length && arr[low] <= X) {
           low++;
        }
        return low;
    }
}