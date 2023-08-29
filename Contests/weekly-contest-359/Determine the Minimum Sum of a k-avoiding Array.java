class Solution {
    public int minimumSum(int n, int k) {
        int minSum = 0;
        Set<Integer> set = new HashSet<>();
        int curr = 1;
        while (n > 0) {
            if (!set.contains(k - curr)) {
                set.add(curr);
                minSum += curr;
                n--;
            }
            curr++;
        }
        return minSum;
    }
}