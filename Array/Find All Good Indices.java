class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n % 2 == 0 && k == n / 2)
            return res;

        int[] toLeft = new int[n];
        int[] toRight = new int[n];

        for (int i = 0; i < n; i++) {
            toLeft[i] = toRight[n - i - 1] = 1;
            if (i == 0)
                continue;
            if (nums[i] <= nums[i - 1]) {
                toLeft[i] = toLeft[i - 1] + 1;
            }
            if (nums[n - i - 1] <= nums[n - i]) {
                toRight[n - i - 1] = toRight[n - i] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1)
                continue;
            int kMin = Math.min(toRight[i + 1], toLeft[i - 1]);
            if (kMin >= k) {
                res.add(i);
            }
        }
        return res;
    }
}