class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int n = nums.length;
        if(n == 1){
            res.add(Integer.toString(nums[0]));
            return res;
        }
        int start = nums[0], end = nums[0];
        for(int i=1; i<n; i++){
            while(i < n && nums[i] == nums[i-1] + 1){
                end = nums[i];
                i++;
            }
            if(start == end){
                res.add(Integer.toString(start));
            }
            else{
                res.add(start+"->"+end);    
            }
            if(i < n){
                start = nums[i];
                end = nums[i];
            }
        }
        if(start == end){
            res.add(Integer.toString(start));
        }
        return res;
    }
}