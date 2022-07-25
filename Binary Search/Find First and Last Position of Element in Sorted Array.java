class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = binSearch(nums, 0, nums.length - 1, target, true);
        int right = binSearch(nums, 0, nums.length - 1, target, false);
        return new int[] { left, right };
    }

    private int binSearch(int[] arr, int lo, int hi, int target, boolean leftBias) {
        int i = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > target) {
                hi = mid - 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                i = mid;
                if (leftBias) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return i;
    }
}