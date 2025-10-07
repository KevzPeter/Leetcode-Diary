class Solution:
    def check(self, nums: List[int]) -> bool:
        n = len(nums)
        flip_idx = 0
        flip_count = 0
        for i in range(n - 1):
            if (nums[i] > nums[i + 1]):
                flip_idx = i + 1
                flip_count += 1
                if (flip_count > 1):
                    return False
        if flip_idx == 0:
            return True
        i = flip_idx
        while (i < n):
            if nums[(i % n)] > nums[((i + 1) % n)]:
                return False
            i += 1
        return True
