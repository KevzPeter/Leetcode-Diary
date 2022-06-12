class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] prefix = new int[n];
        HashMap<Integer, Integer> lastIdx = new HashMap<>();

        // two pointers for sliding window boundaries
        int start = 0, end = 0;

        // variable to keep track of maximum score
        int maxScore = 0;

        // sliding window algorithm
        while (end < n) {
            // generating prefix sum as we traverse the array using end index
            if (end == 0)
                prefix[end] = nums[end];
            else
                prefix[end] = prefix[end - 1] + nums[end];

            // if we encounter a previously seen number at end index, we update start index
            // we use max here to prevent start index from going(left) beyond the current
            // window
            if (lastIdx.containsKey(nums[end])) {
                start = Math.max(start, lastIdx.get(nums[end]) + 1);
            }

            lastIdx.put(nums[end], end);
            int currScore = 0;

            // calculate current score using sums from prefix array
            if (start == 0) {
                currScore = prefix[end];
            } else {
                currScore = prefix[end] - prefix[start - 1];
            }
            maxScore = Math.max(maxScore, currScore);
            end++;
        }
        return maxScore;
    }
}