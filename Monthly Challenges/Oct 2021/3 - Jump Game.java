//Day 3
class Solution {
    public boolean canJump(int[] nums) {
        int min=0;
        int max=0;
            
        while(max<nums.length-1){

            for( int i=0;i<nums.length;i++){
                int l=i;
                int r=i+nums[i];
                if(l<=min && r>max) max=r;
            }
            if(min==max) return false;
            min=max;
        }
        return true;
    }
}