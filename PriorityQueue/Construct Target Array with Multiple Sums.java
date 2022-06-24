class Solution {
    public boolean isPossible(int[] target) {
        if(target == null || target.length == 0) return false;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        long sum = 0;
        
        for(int i : target){
            maxHeap.offer(i);
            sum += i;
        }
        
        while(true){
            int max = maxHeap.poll();
            sum -= max;
            if(max == 1 || sum == 1) return true;
            if(max < sum || sum == 0 || max % sum == 0) return false;
            max %= sum;
            sum += max;
            maxHeap.offer(max);
        }
    }
}