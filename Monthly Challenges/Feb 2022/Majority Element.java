// 21-02-2022
class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(count == 0)
                majority = nums[i];
            if(nums[i] != majority)
                count--;
            else count++;
        }
        return majority;
    }
}