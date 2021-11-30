class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int n=1;
            for(int k=0;k<nums.length;k++)
            {
                if(k!=i)
                n=nums[k]*n;
            }
            ans[i]=n;
        }
        return(ans);
    }
    //O(n) solution
    public int[] productExceptSelf(int[] nums) {
        int ans[]=new int[nums.length];
        int zeroes=0;
        int product=1;
        for( int i=0;i<nums.length;i++){
            if(nums[i]==0) zeroes++;
            else{
                product*=nums[i];
            }
        }
        for( int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ans[i]=zeroes==1?product:0;
            }
            else{
                ans[i]=zeroes>=1?0:product/nums[i];
            }
        }
        return ans;
    }
    //O(n) without division
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}