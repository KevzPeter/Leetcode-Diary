// O(1)
class Solution {
    public int pivotInteger(int n) {
        int ans = (n * n + n) / 2;
        int sq = (int) Math.sqrt(ans);
        return sq * sq == ans ? sq : -1;
    }
}

// O(n)
class Solution2 {
    public int pivotInteger(int n) {
        for (int pivot = 1; pivot <= n; pivot++) {
            int leftSum = (pivot * (pivot + 1)) / 2;
            int rightSum = ((n - pivot + 1) * (pivot + n)) / 2;
            if (leftSum == rightSum)
                return pivot;
        }
        return -1;
    }
}