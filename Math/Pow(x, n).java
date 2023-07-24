class Solution {
    private double binaryExp(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1.0 / binaryExp(x, -1 * n);
        // Perform Binary Exponentiation.
        // If 'n' is odd we perform Binary Exponentiation on 'n - 1' and multiply result
        // with 'x'.
        if (n % 2 == 1)
            return x * binaryExp(x * x, (n - 1) / 2);
        // Otherwise we calculate result by performing Binary Exponentiation on 'n'.
        return binaryExp(x * x, n / 2);
    }

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
}