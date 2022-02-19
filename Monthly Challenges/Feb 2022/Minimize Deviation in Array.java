// 22-02-2022
class Solution {
    public int minimumDeviation(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int minDeviation = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int min = Integer.MAX_VALUE;
        
        for(int i : nums){
            if(i%2 == 1){
                pq.offer(i*2);
                min = Math.min(min, i*2);
            }
            else{
                pq.offer(i);
                min = Math.min(min, i);
            }
        }
        minDeviation = Math.min(minDeviation, pq.peek() - min);
        while(true){
            int max = pq.poll();
            minDeviation  = Math.min(minDeviation, max - min);
            if(max % 2 == 0){
                max /= 2;
                min = Math.min(min, max);
                if(pq.peek() != max)
                    pq.offer(max);
            }
            else break;
        }
        
        return minDeviation;
    }
}