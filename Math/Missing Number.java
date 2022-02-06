class Solution {
    public int missingNumber(int[] nums) {
        int arraysum=0;
        for(int i=0;i<nums.length;i++){
            arraysum+=nums[i];
            }
        int ans=(nums.length*(nums.length+1))/2-arraysum;
        return ans;
    }
}