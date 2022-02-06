class Solution {
    public int minPatches(int[] nums, int n) {
        
        int i=0;
        int count=0;
        long reach=0;
        
        while(reach<n){
            
            if(i>=nums.length){
                reach+=reach+1;
                count++;
            }
            else if(i <nums.length && nums[i]<=reach+1){
                reach+=nums[i];
                i++;
            }
            else{
                reach+=reach+1;
                count++;
            }
        }
        return count;
    }
}