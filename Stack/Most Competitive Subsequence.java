class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && (n - i - 1) >= k) {
                stack.pop();
                k++;
            }
            if (k == 0)
                continue;
            stack.push(nums[i]);
            k--;
        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}