// 15-02-2022 
class Solution {
    public int singleNumber(int[] nums) {
        int singleNumber = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++)
            singleNumber ^= nums[i];
        return singleNumber;
    }
}