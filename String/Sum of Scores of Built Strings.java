class Solution {
    public long sumScores(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        long[] zScore = new long[n];
        char[] input = s.toCharArray();
        int left = 0;
        int right = 0;
        zScore[0] = n;
        for (int k = 1; k < input.length; k++) {
            if (k > right) {
                left = right = k;
                while (right < input.length && input[right] == input[right - left]) {
                    right++;
                }
                zScore[k] = right - left;
                right--;
            } else {
                // we are operating inside box
                int k1 = k - left;
                // if value does not stretches till right bound then just copy it.
                if (zScore[k1] < right - k + 1) {
                    zScore[k] = zScore[k1];
                } else { // otherwise try to see if there are more matches.
                    left = k;
                    while (right < input.length && input[right] == input[right - left]) {
                        right++;
                    }
                    zScore[k] = right - left;
                    right--;
                }
            }
        }

        long sumScore = 0;
        for (long score : zScore) {
            sumScore += score;
        }

        return sumScore;
    }
}