class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        maxSum = curSum = nums[0]
        for i in range(1, len(nums)):
            curSum = curSum + nums[i] if nums[i] > nums[i - 1] else nums[i]
            maxSum = max(maxSum, curSum)
        return maxSum
            