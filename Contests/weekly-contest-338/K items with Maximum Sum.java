class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        if (k > 0) {
            sum += Math.min(k, numOnes);
            k -= Math.min(k, numOnes);
        }
        if (k > 0) {
            k -= Math.min(k, numZeros);
        }
        if (k > 0) {
            sum -= Math.min(k, numNegOnes);
        }
        return sum;
    }
}
