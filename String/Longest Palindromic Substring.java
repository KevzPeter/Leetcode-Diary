class Solution {

    private int lo, maxLen = 0;

    public String longestPalindrome(String s) {

        if (s.length() < 2)
            return s;

        for (int i = 0; i < s.length(); i++) {
            extendpalindrome(s, i, i);
            extendpalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    void extendpalindrome(String s, int i, int j) {
        while ((i >= 0 && j < s.length()) && (s.charAt(i) == s.charAt(j))) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            maxLen = j - i - 1;
            lo = i + 1;
        }
    }
}