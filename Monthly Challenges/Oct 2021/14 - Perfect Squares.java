class Solution {
    public int numSquares(int n) {
        
       if (n <= 0)
        {
            return 0;
        }
        
        
        int cntPerfectSquares[]=new int[n+1];
        Arrays.fill(cntPerfectSquares,Integer.MAX_VALUE);
        cntPerfectSquares[0] = 0;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j*j <= i; j++)
            {
                cntPerfectSquares[i] = 
                    Math.min(cntPerfectSquares[i], cntPerfectSquares[i - j*j] + 1);
            }
        }
        
        return cntPerfectSquares[n];
    }
}