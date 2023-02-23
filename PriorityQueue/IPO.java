class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        int maxCapital = 0;
        int n = profits.length;
        int[][] projects = new int[n][2];
        for(int i = 0; i < n; i++){
            projects[i][0] = profits[i];
            projects[i][1] = capitals[i];
        }
        Arrays.sort(projects, (a, b) -> (a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        while(k-- > 0){
            while(index < n && projects[index][1] <= w){
                pq.offer(projects[index][0]);
                index++;
            }
            if(pq.size() == 0) return w;
            w += pq.poll();
        }
        return w;
    }
}