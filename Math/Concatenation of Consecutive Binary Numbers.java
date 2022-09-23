// daily challenge 9/24/22
class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int concatenatedBinary(int n) {
        int len = 0;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            // increase length when i is a power of 2
            if ((i & (i - 1)) == 0)
                len++;
            ans = ((ans << len) % MOD + i) % MOD;
        }
        return (int) ans;
    }
}