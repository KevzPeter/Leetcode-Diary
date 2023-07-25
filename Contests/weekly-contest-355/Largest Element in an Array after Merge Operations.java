import java.util.Stack;

class Solution {
    public long maxArrayValue(int[] nums) {
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= sum)
                sum += nums[i];
            else
                sum = nums[i];
        }
        return sum;
    }
}

class StackSolution {
    public long maxArrayValue(int[] nums) {
        Stack<Long> stack = new Stack<>();
        if (nums == null || nums.length == 0)
            return 0;

        for (int num : nums) {
            stack.push(num * 1l);
        }

        while (stack.size() > 1) {
            long n1 = stack.pop();
            long n2 = stack.pop();

            if (n2 > n1) {
                stack.push(n2);
            } else
                stack.push(n1 + n2);
        }

        return stack.pop();
    }
}