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
}