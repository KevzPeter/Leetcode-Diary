class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int x) {
        int sum = 0;
        for (int k = 0; k < nums.size(); k++) {
            int n = k;
            int setBits = 0;
            while (n > 0) {
                setBits += (n & 1);
                n >>= 1;
            }
            if (setBits == x) {
                sum += nums.get(k);
            }
        }
        return sum;
    }
}