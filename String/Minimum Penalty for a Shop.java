class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        for (int i = 0; i < n; i++) {
            char c1 = customers.charAt(i);
            char c2 = customers.charAt(n - i - 1);
            if (i != 0) {
                suffix[n - i - 1] = suffix[n - i];
                prefix[i] = prefix[i - 1];
            }
            prefix[i] += c1 == 'N' ? 1 : 0;
            suffix[n - i - 1] += c2 == 'Y' ? 1 : 0;
        }

        int minPenalty = n;
        int idx = 0;

        for (int i = 0; i <= n; i++) {
            int currPenalty = 0;
            if (i > 0)
                currPenalty += prefix[i - 1];
            if (i <= n - 1)
                currPenalty += suffix[i];
            if (currPenalty < minPenalty) {
                minPenalty = currPenalty;
                idx = i;
            }
        }

        return idx;
    }
}