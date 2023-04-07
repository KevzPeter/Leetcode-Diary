class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len + 1; j++) {
                max = Math.max(max, findLength(s.substring(i, j)));
            }
        }
        return max;
    }

    private int findLength(String s) {
        if (s.length() % 2 != 0)
            return -1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) - '0' != 0)
                return -1;
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (s.charAt(i) - '0' != 1)
                return -1;
        }
        return s.length();
    }
}