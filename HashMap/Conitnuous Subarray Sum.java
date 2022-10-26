class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length <= 1) return false;
        int n = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            sum += nums[i];
            sum %= k;
            if(sum == 0 && i > 0) return true;
            
            if(map.containsKey(sum)){
                if((i - map.get(sum)) >= 2) return true;
            }
            else map.put(sum, i);
        }
        
        return false;
    }
}