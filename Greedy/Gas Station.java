class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, totalGas = 0, totalCost = 0;
        for(int i = 0; i < n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalCost > totalGas) return -1;
        int currGas = 0, stationsPassed = 0;
        for(int i = 0; i  < (2 * n); i++){
            int idx = i % n;
            if(currGas + gas[idx] >= cost[idx]){
                currGas += gas[idx] - cost[idx];
                ++stationsPassed;
                if(stationsPassed == n) return (idx + 1) % n;
            }
            else{
                currGas = 0;
                stationsPassed = 0;
            }
        }
        return -1;
    }
}