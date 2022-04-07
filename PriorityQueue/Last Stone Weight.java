// author : @kevzpeter
// TC : O(log n)
// SC : O(n)

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }
        int x, y;
        while(pq.size() >= 2){
            y = pq.poll();
            x = pq.poll();
            if(y >= x) pq.offer(y-x);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}