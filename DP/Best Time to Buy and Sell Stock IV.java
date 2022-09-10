class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] memo = new int[prices.length][k + 1][2];
        for(int[][] mm : memo){
            for(int[] m : mm){
                Arrays.fill(m, -1);    
            }
        }
        return helper(0, k, prices, 0, memo);
    }
    private int helper(int i, int k, int[] prices, int curr, int[][][] memo){
        if(i >= prices.length || k == 0) return 0;
        if(memo[i][k][curr] != -1) return memo[i][k][curr];
        int ans = 0;
        if(curr == 0){
            int buy = helper(i + 1, k, prices, 1, memo) - prices[i];
            int dontBuy = helper(i + 1, k, prices, 0, memo);
            ans = Math.max(buy, dontBuy);
        }
        else{
            int sell = helper(i + 1, k - 1, prices, 0, memo) + prices[i];
            int dontSell = helper(i + 1, k, prices, 1, memo);
            ans = Math.max(sell, dontSell);
        }
        return memo[i][k][curr] = ans;
    }
}