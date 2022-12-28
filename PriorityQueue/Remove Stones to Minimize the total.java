class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int total = 0;
        for(int i : piles){
            total += i;
            pq.offer(i);
        } 
        while(k-->0){
            int maxPile = pq.poll();
            int newPile = (maxPile >> 1) + (maxPile & 1);
            int removedPile = maxPile - newPile;
            pq.offer(newPile);
            total -= removedPile;
        }
        return total;
    }
}