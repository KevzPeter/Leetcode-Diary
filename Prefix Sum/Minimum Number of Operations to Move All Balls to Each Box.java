/**
 * Source :
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 * Author: KevzPeter
 * Date : 01-06-2025
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public int[] minOperations(String boxes) {
        if (boxes == null || boxes.length() == 0)
            return new int[0];
        if (boxes.length() == 1) {
            return new int[] { 0 };
        }

        int n = boxes.length();
        int[] res = new int[n];
        int[][] prefix = new int[n][2], suffix = new int[n][2];

        for (int i = 0; i < n; i++) {
            char firstChar = boxes.charAt(i), lastChar = boxes.charAt(n - i - 1);
            int prefixIndexSum = 0, prefixCount = 0, suffixIndexSum = 0, suffixCount = 0;

            if (i == 0) {
                prefixIndexSum = (firstChar == '1' ? i : 0);
                prefixCount = (firstChar == '1' ? 1 : 0);
                suffixIndexSum = (lastChar == '1' ? n - i - 1 : 0);
                suffixCount = (lastChar == '1' ? 1 : 0);
            } else {
                prefixIndexSum = (firstChar == '1' ? i + prefix[i - 1][0] : prefix[i - 1][0]);
                prefixCount = (firstChar == '1' ? prefix[i - 1][1] + 1 : prefix[i - 1][1]);
                suffixIndexSum = (lastChar == '1' ? n - i - 1 + suffix[n - i][0] : suffix[n - i][0]);
                suffixCount = (lastChar == '1' ? suffix[n - i][1] + 1 : suffix[n - i][1]);
            }
            prefix[i] = new int[] { prefixIndexSum, prefixCount };
            suffix[n - i - 1] = new int[] { suffixIndexSum, suffixCount };
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = suffix[i + 1][0] - suffix[i + 1][1] * i;
            } else if (i == n - 1) {
                res[i] = prefix[i - 1][1] * i - prefix[i - 1][0];
            } else {
                res[i] = (prefix[i - 1][1] * i - prefix[i - 1][0]) + (suffix[i + 1][0] - suffix[i + 1][1] * i);
            }
        }

        return res;
    }
}