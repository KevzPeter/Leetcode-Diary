class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str2 == null || str2.length() == 0)
            return true;
        if (str1 == null || str1.length() < str2.length())
            return false;

        int i = 0, j = 0, len1 = str1.length(), len2 = str2.length();
        char[] str1Chars = str1.toCharArray(), str2Chars = str2.toCharArray();

        while (i < len1 && j < len2) {
            if (str1Chars[i] == str2Chars[j] || (str2Chars[j] == ((char) ('a' + ((str1Chars[i] - 'a') + 1) % 26)))) {
                j++;
            }
            i++;
        }
        return j == len2;
    }
}