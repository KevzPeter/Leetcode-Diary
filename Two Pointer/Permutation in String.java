class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        int n = s1.length();
        for (int end = 0; end < s2.length(); end++) {
            char e = s2.charAt(end);
            freq[e - 'a']--;
            if (end >= n) {
                char s = s2.charAt(end - n);
                freq[s - 'a']++;
            }
            if (end >= n - 1 && isZero(freq))
                return true;
        }
        return isZero(freq);
    }

    private boolean isZero(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return false;
        }
        return true;
    }
}