class Solution {
    class OfferComparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> l1, List<Integer> l2) {
            return l1.get(0) - l2.get(0);
        }
    }

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int len = offers.size();
        int[] memo = new int[len];
        Arrays.fill(memo, -1);
        Collections.sort(offers, new OfferComparator());
        return helper(0, offers, memo);
    }

    private int helper(int i, List<List<Integer>> offers, int[] memo) {
        if (i == offers.size())
            return 0;
        if (memo[i] != -1)
            return memo[i];

        int notSell = helper(i + 1, offers, memo);
        int low = i + 1, high = offers.size() - 1;
        int nextIdx = offers.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (offers.get(mid).get(0) > offers.get(i).get(1)) {
                high = mid - 1;
                nextIdx = mid;
            } else {
                low = mid + 1;
            }
        }

        int sell = offers.get(i).get(2) + helper(nextIdx, offers, memo);
        int maxProfit = Math.max(sell, notSell);

        return memo[i] = maxProfit;
    }
}