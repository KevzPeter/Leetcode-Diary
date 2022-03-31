class Solution {
    public int splitArray(int[] nums, int m) {
        int minVal = 0, maxVal = 0;
        for(int num : nums){
            minVal = Math.max(minVal, num);
            maxVal += num;
        }
        while(minVal < maxVal){
            int mid = minVal + (maxVal - minVal) / 2;
            if(canSplit(mid, nums, m)){
                maxVal = mid;
            }
            else{
                minVal = mid + 1;
            }
        }
        return minVal;
    }
    private boolean canSplit(int upperBound, int[] arr, int m){
        int subArrSum = 0, cnt = 1;
        for(int num : arr){
            subArrSum += num;
            if(subArrSum > upperBound){
                subArrSum = num;
                cnt++;
                if(cnt > m) return false;
            }
        }
        return true;
    }
}