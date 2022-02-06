class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        Arrays.sort(nums);
        Arrays.sort(nums, (String a, String b)->a.length()-b.length());
        return nums[nums.length-k];
        
    }
}