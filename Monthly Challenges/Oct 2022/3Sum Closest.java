// Daily Challenge : 8/10/22
// TC : O(N^2)
// SC : O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int absDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int currSum = nums[i] + nums[start] + nums[end];
                if (currSum > target)
                    end--;
                else if (currSum < target)
                    start++;
                else
                    return target;
                if (Math.abs(currSum - target) < absDiff) {
                    closest = currSum;
                    absDiff = Math.abs(currSum - target);
                }
            }
        }
        return closest;
    }
}
