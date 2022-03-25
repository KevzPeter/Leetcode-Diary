class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length >> 1;
        int[] refunds = new int[2*n];
        int aCost = 0;
        for(int i=0; i<2*n; i++){
            aCost += costs[i][0];
            int refund = costs[i][1] - costs[i][0];
            refunds[i] = refund;
        }
        Arrays.sort(refunds);
        for(int i=0; i<n; i++){
            aCost += refunds[i];
        }
        return aCost;
    }
}