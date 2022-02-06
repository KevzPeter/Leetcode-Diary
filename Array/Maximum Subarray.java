class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=0;
        int i=0;
        while( i<nums.length){
            sum+=nums[i];
            if(sum>max)
                max=sum;
            if(sum<0){
                sum=0;
            }
            i++;
        }
        return max;
    }
}