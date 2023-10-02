class Solution {
    public int minSizeSubarray(int[] A, int target) {
        long sumA = 0L, su = 0L;
        for (int num : A) {
            sumA += num;
        }
        int n = A.length, k = (int) (target / sumA), res = n;
        target %= sumA;

        if (target == 0) {
            return k * n;
        }

        Map<Long, Integer> dp = new HashMap<>();
        dp.put(0L, -1);

        for (int i = 0; i < n * 2; i++) {
            su += A[i % n];

            if (dp.containsKey(su - target)) {
                res = Math.min(res, i - dp.get(su - target));
            }

            dp.put(su, i);
        }

        return (res < n) ? res + k * n : -1;
    }
}