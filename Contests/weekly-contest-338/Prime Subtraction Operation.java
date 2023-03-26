class Solution {
    private static List<Integer> primes;

    public boolean primeSubOperation(int[] nums) {
        if (primes == null)
            generatePrimes();
        for (int i = 0; i < nums.length; i++) {
            int lowerPrimeIdx = binSearch(nums[i]);
            for (int j = lowerPrimeIdx; j >= 0; j--) {
                if (primes.get(lowerPrimeIdx) >= nums[i])
                    continue;
                if (i > 0 && nums[i] - primes.get(j) <= nums[i - 1])
                    continue;
                else {
                    nums[i] -= primes.get(j);
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1])
                return false;
        }
        return true;
    }

    private int binSearch(int target) {
        int low = 0, high = primes.size() - 1;
        while (low < high) {
            int mid = high - (high - low) / 2;
            if (primes.get(mid) >= target)
                high = mid - 1;
            else
                low = mid;
        }
        return low;
    }

    private void generatePrimes() {
        primes = new ArrayList<>();
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2 * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}