class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] newArr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            newArr[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return triangularSum(newArr);
    }
}