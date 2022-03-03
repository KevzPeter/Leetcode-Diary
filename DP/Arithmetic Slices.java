// TC : O(n)
// SC : O(n)
class Solution1 {
    //int count = 0;
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<=2) return 0;
        int[] arSlices = new int[n];
        arSlices[0] = 0;
        arSlices[1] = 0;
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                arSlices[i] = arSlices[i-1] + 1;
            }
            else{
                arSlices[i] = 0;
            }
        }
        return Arrays.stream(arSlices).sum();
    }
    
}
// TC : O(n)
// SC : O(1)
class Solution2 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<=2) return 0;
        int count = 0, curr = 0, prev = 0;
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                curr = prev + 1;
                prev = curr;
            }
            else{
                curr = prev = 0;
            }
            count += curr;
        }
        return count;
    }
}