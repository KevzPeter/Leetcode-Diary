class Solution {
    public long maxKelements(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.offer(num);
        }
        long score = 0;
        while (k-- > 0) {
            int max = pq.poll();
            score += max;
            pq.offer((int) Math.ceil(max / 3.0));
        }
        return score;
    }
}