//DP version
class Solution {
    public int countVowelPermutation(int n) {
        int MOD = (int)1e9 + 7;
        long[][] dp = new long[n+1][5];
        
        for(int i = 0; i < 5; i++)
            dp[1][i] = 1;
    
        for(int i = 1; i < n; i++){
            dp[i+1][0] = (dp[i][1] + dp[i][2] + dp[i][4]) %MOD;

            dp[i+1][1] = (dp[i][0] + dp[i][2]) % MOD;

            dp[i+1][2] = (dp[i][1] + dp[i][3]) % MOD;

            dp[i+1][3] = dp[i][2];

            dp[i+1][4] = (dp[i][2] + dp[i][3]) % MOD;
        }
    
        long res = 0;
        for(int i = 0; i < 5; i++)
            res = (res + dp[n][i]) % MOD;

        return (int)res;
    }
}
//Memoized version
class Solution {
    private static final int MOD = (int)1e9 + 7;
    private static final String vowels = "aeiou";
    public int countVowelPermutation(int n) {
        int[][] memo = new int[n+1][5];
        for(int[] m : memo){
            Arrays.fill(m, -1);
        }
        return helper(0, ' ', n, memo); 
    }
    private int helper(int i, char prev, int n, int[][] memo){
        if(i == n) return 1;
        if(i != 0 && memo[i][vowels.indexOf(prev)] != -1) return memo[i][vowels.indexOf(prev)];
        int ans = 0;
        if(i == 0){
            for(char c : vowels.toCharArray()){
                ans = (ans + helper(i+1, c, n, memo)) % MOD;
            }
            return ans;
        }
        else if(prev == 'a'){
            ans = (ans + helper(i+1, 'e', n, memo)) % MOD;
        }
        else if(prev == 'e'){
            ans = ((ans + helper(i+1, 'a', n, memo)) % MOD + helper(i+1, 'i', n, memo)) % MOD;
        }
        else if(prev == 'i'){
            for(char c : vowels.toCharArray()){
                if(c != 'i'){
                    ans = (ans + helper(i+1, c, n, memo)) % MOD;
                }
            }
        }
        else if(prev == 'o'){
            ans = ((ans + helper(i+1, 'i', n, memo)) % MOD + helper(i+1, 'u', n, memo)) % MOD;
        }
        else if(prev == 'u'){
            ans = (ans + helper(i+1, 'a', n, memo)) % MOD;
        }
        return memo[i][vowels.indexOf(prev)] = ans;
    }
}