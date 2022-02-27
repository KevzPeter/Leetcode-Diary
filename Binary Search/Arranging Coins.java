class Solution {
    public int arrangeCoins(int n) {
        int random = (int) (Math.random() * 3);
        if (random == 1)
            return iterative(n);
        else if (random == 2)
            return binSearch(n);
        else
            return quickMaffs(n);
    }

    int iterative(int n) {
        int i = 1;
        while (n > 0) {
            i++;
            n -= i;
        }
        return i - 1;
    }

    int binSearch(int n) {
        long left = 0; // we use "long" because we may get an integer overflow
        long right = n;
        while (left <= right) {
            long pivot = left + (right - left) / 2;
            long coinsUsed = pivot * (pivot + 1) / 2;
            if (coinsUsed == n) {
                return (int) pivot;
            }
            if (n < coinsUsed) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return (int) right; // cast as an "int" because it was initiliazed as a "long"
    }

    int quickMaffs(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}