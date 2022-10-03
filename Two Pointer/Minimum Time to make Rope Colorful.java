/*
 * Daily challenge: 3/10/22
 * TC : O(n)
 * SC : O(1)
 */
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minCost = 0;
        int start = 0, end = 1;
        int n = colors.length();
        while (end < n) {
            if (colors.charAt(end) == colors.charAt(start)) {
                if (neededTime[start] < neededTime[end]) {
                    minCost += neededTime[start];
                    start = end;
                } else {
                    minCost += neededTime[end];
                }
            } else {
                start = end;
            }
            end = end + 1;
        }
        return minCost;
    }
}