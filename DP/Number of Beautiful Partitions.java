import java.util.*;

class Solution {
    private static final HashSet<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7));
    private static final int MOD = (int) (1e9 + 7);

    public int beautifulPartitions(String s, int k, int minLength) {
        final int len = s.length();
        int[][] memo = new int[len + 1][k + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return helper(0, s, k, minLength, memo);
    }

    private int helper(int i, String s, int k, int minLength, int[][] memo) {
        if (i == s.length()) {
            if (k == 0)
                return 1;
            return 0;
        }
        if (k <= 0 || i > s.length() - minLength * k)
            return 0;

        if (memo[i][k] != -1)
            return memo[i][k];

        int ans = 0;
        int currentDigit = s.charAt(i) - '0';

        if (!primes.contains(currentDigit))
            return memo[i][k] = ans;

        for (int j = i + minLength - 1; j < s.length() && j < s.length() - minLength * k + minLength; j++) {
            currentDigit = s.charAt(j) - '0';
            if (!primes.contains(currentDigit)) {
                ans = (ans % MOD + (helper(j + 1, s, k - 1, minLength, memo) % MOD) % MOD);
            }
        }

        return memo[i][k] = ans;
    }
}