class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    void reverse(int[] arr, int a, int b) {
        while (a < b)
            swap(arr, a++, b--);
    }
}