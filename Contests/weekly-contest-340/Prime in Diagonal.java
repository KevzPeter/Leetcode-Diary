class Solution {
    private static boolean notPrime[];

    public int diagonalPrime(int[][] nums) {
        if (notPrime == null) {
            notPrime = new boolean[4 * (int) 1e6 + 1];
            generatePrimes();
        }
        int maxPrime = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val1 = nums[i][i];
            int val2 = nums[i][n - i - 1];
            if (!notPrime[val1]) {
                maxPrime = Math.max(maxPrime, val1);
            }
            if (!notPrime[val2]) {
                maxPrime = Math.max(maxPrime, val2);
            }
        }
        return maxPrime;
    }

    private void generatePrimes() {
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i * i < notPrime.length; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < notPrime.length; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }
}